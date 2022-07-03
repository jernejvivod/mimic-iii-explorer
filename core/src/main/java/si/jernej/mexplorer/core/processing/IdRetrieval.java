package si.jernej.mexplorer.core.processing;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.BadRequestException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.jernej.mexplorer.core.util.EntityUtils;
import si.jernej.mexplorer.processorapi.v1.model.IdRetrievalFilterSpecDto;
import si.jernej.mexplorer.processorapi.v1.model.IdRetrievalSpecDto;

@Stateless
public class IdRetrieval
{
    private static final Logger logger = LoggerFactory.getLogger(IdRetrieval.class);

    @PersistenceContext
    private EntityManager em;

    /**
     * Retrieve ids of specified entities with specified entity filtering.
     *
     * @param idRetrievalSpecDto specification for filtering of entities
     * @return list of retrieved ids
     */
    public Set<Object> retrieveIds(IdRetrievalSpecDto idRetrievalSpecDto)
    {
        logger.info(".retrieveIds extracting ids");
        logger.info(".retrieveIds root entity name: {}, root entity ID property {}, number of filter specifications {}",
                idRetrievalSpecDto.getEntityName(),
                idRetrievalSpecDto.getIdProperty(),
                Optional.ofNullable(idRetrievalSpecDto.getFilterSpecs()).map(List::size).orElse(0)
        );

        // retrieve all specified entities for filtering
        List<Object> entitiesAll;
        try
        {
            entitiesAll = em.createQuery(String.format("SELECT e FROM %s e WHERE e.%s IS NOT NULL",
                    idRetrievalSpecDto.getEntityName(),
                    idRetrievalSpecDto.getIdProperty()
            ), Object.class).getResultList();
        }
        catch (IllegalArgumentException e)
        {
            throw new BadRequestException(e.getMessage());
        }

        // set current set of filtered entities and initialize empty set for adding entities for the next filtering
        Set<Object> entitiesFiltered = new HashSet<>(entitiesAll);
        Set<Object> entitiesFilteredNxt = new HashSet<>();

        // get map of entities to their linked entities
        Map<String, Set<String>> entityToLinkedEntities = EntityUtils.computeEntityToLinkedEntitiesMap(em.getMetamodel());

        // go over filtering specifications
        if (idRetrievalSpecDto.getFilterSpecs() != null)
        {
            for (IdRetrievalFilterSpecDto filterSpec : idRetrievalSpecDto.getFilterSpecs())
            {
                List<String> foreignKeyPath = EntityUtils.computeForeignKeyPath(idRetrievalSpecDto.getEntityName(), filterSpec.getEntityName(), entityToLinkedEntities);
                for (Object entity : entitiesFiltered)
                {
                    // get entity at end of foreign key path and make sure path is singular
                    Set<Object> entityEndFkPath = EntityUtils.traverseForeignKeyPath(entity, foreignKeyPath);
                    if (entityEndFkPath.size() > 1)
                    {
                        throw new IllegalArgumentException("Entity used to filter the ids should be reachable by an all-singular path");
                    }

                    // filter
                    Object entityForFiltering = entityEndFkPath.iterator().next();
                    try
                    {
                        // compare property for filtering
                        Object propertyForFiltering = PropertyUtils.getProperty(entityForFiltering, filterSpec.getPropertyName());
                        if (propertyForFiltering != null)
                        {
                            boolean compResult = switch (filterSpec.getComparator())
                                    {
                                        case LESS -> ((Comparable) propertyForFiltering).compareTo(filterSpec.getPropertyVal()) < 0;
                                        case MORE -> ((Comparable) propertyForFiltering).compareTo(filterSpec.getPropertyVal()) > 0;
                                        case EQUAL -> ((Comparable) propertyForFiltering).compareTo(filterSpec.getPropertyVal()) == 0;
                                    };

                            // if filtering criteria satisfied add to list of filtered entities
                            if (compResult)
                            {
                                entitiesFilteredNxt.add(entity);
                            }
                        }
                    }
                    catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
                    {
                        throw new IllegalArgumentException(String.format("Specified property '%s' for filtering of entity '%s' is not valid", filterSpec.getPropertyName(), filterSpec.getEntityName()));
                    }
                }
                entitiesFiltered = new HashSet<>(entitiesFilteredNxt);
                entitiesFilteredNxt.clear();
            }
        }

        // get id values
        Set<Object> ids = new HashSet<>();
        for (Object entity : entitiesFiltered)
        {
            try
            {
                ids.add(BeanUtils.getProperty(entity, idRetrievalSpecDto.getIdProperty()));
            }
            catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
            {
                throw new IllegalArgumentException(String.format("Specified property '%s' for filtering of entity '%s' is not valid", idRetrievalSpecDto.getIdProperty(), idRetrievalSpecDto.getEntityName()));
            }
        }
        return ids;
    }
}
