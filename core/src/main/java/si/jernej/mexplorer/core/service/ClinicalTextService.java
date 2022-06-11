package si.jernej.mexplorer.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.google.common.collect.Iterables;

import si.jernej.mexplorer.core.util.EntityUtils;
import si.jernej.mexplorer.processorapi.v1.model.ClinicalTextConfigDto;
import si.jernej.mexplorer.processorapi.v1.model.ClinicalTextResultDto;
import si.jernej.mexplorer.processorapi.v1.model.DataRangeSpecDto;

@Dependent
public class ClinicalTextService
{
    /**
     * Extract clinical text given specified configuration.
     *
     * @param clinicalTextConfigDto configuration for extracting clinical text
     * @return extracted clinical text for each specified root entity
     */
    public Set<ClinicalTextResultDto> extractClinicalText(ClinicalTextConfigDto clinicalTextConfigDto)
    {
        DataRangeSpecDto dataRangeSpec = clinicalTextConfigDto.getDataRangeSpec();
        String rootEntityName = clinicalTextConfigDto.getRootEntitiesSpec().getRootEntity();
        String idPropertyName = clinicalTextConfigDto.getRootEntitiesSpec().getIdProperty();

        // EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("primary");
        EntityManager em = emf.createEntityManager();

        // compute foreign key path from root entity to NoteEventsEntity
        Map<String, Set<String>> entityToLinkedEntities = EntityUtils.computeEntityToLinkedEntitiesMap(emf.getMetamodel());
        List<String> foreignKeyPath = EntityUtils.computeForeignKeyPath(rootEntityName, "NoteEventsEntity", entityToLinkedEntities);

        // Set for storing results
        Set<ClinicalTextResultDto> results = new HashSet<>();

        // extract root entities and their ids
        em.getTransaction().begin();
        List<Object[]> rootEntitiesAndIds = em.createQuery(String.format("SELECT e, e.%1$s FROM %2$s e WHERE e.%1$s IN (:ids)",
                        idPropertyName, rootEntityName), Object[].class)
                .setParameter("ids", clinicalTextConfigDto.getRootEntitiesSpec().getIds())
                .getResultList();

        // map ids of root entities to corresponding clinical text ids
        Map<Object, Set<Integer>> rootEntityIdToNoteEventsIds = new HashMap<>();
        for (Object[] rootEntityAndId : rootEntitiesAndIds)
        {
            // get clinical texts for root entities
            Set<Integer> clinicalTextIds = EntityUtils.computeIdPropertyValuesForForeignPathEnd(rootEntityAndId[0], foreignKeyPath);
            rootEntityIdToNoteEventsIds.put(rootEntityAndId[1], clinicalTextIds);
        }

        // get set of clinical text ids for all root entities (for DB query)
        Set<Integer> clinicalTextIds = rootEntityIdToNoteEventsIds.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        // extract texts and row ids
        List<Object[]> textsAndRowId = new ArrayList<>(clinicalTextIds.size());
        for (List<Integer> clinicalTextIdsPartition : Iterables.partition(clinicalTextIds, 10000))
        {
            TypedQuery<Object[]> clinicalTextsQuery = em.createQuery(
                            "SELECT n.text, n.rowId FROM NoteEventsEntity n WHERE n.rowId IN (:ids) ORDER BY n.chartdate",
                            Object[].class
                    )
                    .setParameter("ids", clinicalTextIdsPartition);
            textsAndRowId.addAll(clinicalTextsQuery.getResultList());
        }

        // construct results
        rootEntityIdToNoteEventsIds.forEach((rootEntityId, neRowIds) -> {
            List<String> textsForRootEntity = new ArrayList<>();
            for (Object[] textAndRowId : textsAndRowId)
            {
                if (neRowIds.contains(textAndRowId[1]))
                {
                    textsForRootEntity.add((String) textAndRowId[0]);
                }
            }
            ClinicalTextResultDto clinicalTextResultDto = new ClinicalTextResultDto();
            clinicalTextResultDto.setText(String.join(" ", textsForRootEntity));
            clinicalTextResultDto.setRootEntityId((Long) rootEntityId);
            results.add(clinicalTextResultDto);
        });

        return results;
    }
}
