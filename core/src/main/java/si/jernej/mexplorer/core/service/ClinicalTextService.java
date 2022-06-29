package si.jernej.mexplorer.core.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;

import si.jernej.mexplorer.core.util.EntityUtils;
import si.jernej.mexplorer.processorapi.v1.model.ClinicalTextConfigDto;
import si.jernej.mexplorer.processorapi.v1.model.ClinicalTextResultDto;
import si.jernej.mexplorer.processorapi.v1.model.DataRangeSpecDto;

@Dependent
public class ClinicalTextService
{
    private static final Logger logger = LoggerFactory.getLogger(ClinicalTextService.class);

    /**
     * Extract clinical text given specified configuration.
     *
     * @param clinicalTextConfigDto configuration for extracting clinical text
     * @return extracted clinical text for each specified root entity
     */
    public Set<ClinicalTextResultDto> extractClinicalText(ClinicalTextConfigDto clinicalTextConfigDto)
    {
        logger.info(".extractClinicalText extracting clinical text");  // TODO log request details

        DataRangeSpecDto dataRangeSpec = clinicalTextConfigDto.getDataRangeSpec();
        String rootEntityName = clinicalTextConfigDto.getRootEntitiesSpec().getRootEntity();
        String idPropertyName = clinicalTextConfigDto.getRootEntitiesSpec().getIdProperty();

        // EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("primary");
        EntityManager em = emf.createEntityManager();

        // compute foreign key path from root entity to NoteEventsEntity
        Map<String, Set<String>> entityToLinkedEntities = EntityUtils.computeEntityToLinkedEntitiesMap(emf.getMetamodel());
        List<String> foreignKeyPath = EntityUtils.computeForeignKeyPath(rootEntityName, "NoteEventsEntity", entityToLinkedEntities);

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

        // Set for storing results
        Set<ClinicalTextResultDto> results = new HashSet<>();

        // extract texts and row ids
        List<Object[]> textsRowIdChartDate = new ArrayList<>(clinicalTextIds.size());
        for (List<Integer> clinicalTextIdsPartition : Iterables.partition(clinicalTextIds, 10000))
        {
            TypedQuery<Object[]> clinicalTextsQuery = em.createQuery(
                            "SELECT n.text, n.rowId, n.charttime FROM NoteEventsEntity n WHERE n.rowId IN (:ids) ORDER BY n.charttime",
                            Object[].class
                    )
                    .setParameter("ids", clinicalTextIdsPartition);
            textsRowIdChartDate.addAll(clinicalTextsQuery.getResultList());
        }

        // construct results
        rootEntityIdToNoteEventsIds.forEach((rootEntityId, neRowIds) -> {

            List<ImmutablePair<String, Timestamp>> textsAndChartTimesForRootEntity = new ArrayList<>();
            for (Object[] textAndRowId : textsRowIdChartDate)
            {
                if (neRowIds.contains(textAndRowId[1]))
                {
                    if (dataRangeSpec != null && textAndRowId[2] == null)
                    {
                        continue;
                    }
                    textsAndChartTimesForRootEntity.add(ImmutablePair.of((String) textAndRowId[0], (Timestamp) textAndRowId[2]));
                }
            }

            if (!textsAndChartTimesForRootEntity.isEmpty())
            {
                // if limiting text by charttime
                if (dataRangeSpec != null)
                {
                    textsAndChartTimesForRootEntity.sort(Comparator.comparing(ImmutablePair::getRight));
                    Timestamp initialTimestamp = textsAndChartTimesForRootEntity.get(0).getRight();
                    textsAndChartTimesForRootEntity = textsAndChartTimesForRootEntity.stream()
                            .filter(e -> TimeUnit.MILLISECONDS.toMinutes(e.getRight().getTime() - initialTimestamp.getTime()) < clinicalTextConfigDto.getDataRangeSpec().getFirstMinutes())
                            .toList();
                }

                ClinicalTextResultDto clinicalTextResultDto = new ClinicalTextResultDto();
                clinicalTextResultDto.setText(String.join(" ", textsAndChartTimesForRootEntity.stream().map(ImmutablePair::getLeft).toList()));
                clinicalTextResultDto.setRootEntityId((Long) rootEntityId);
                results.add(clinicalTextResultDto);
            }
        });
        return results;
    }
}
