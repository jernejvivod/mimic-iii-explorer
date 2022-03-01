package si.jernej.mexplorer.core.processing;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;

import si.jernej.mexplorer.core.transform.ValueTransformer;

@Stateless
public class Wordification
{

    /**
     * Enum used to specify which concatenation schema to use.
     * {@code ZERO} means not to use any concatenations.
     * {@code ONE} means to concatenate pairs of features.
     * {@code TWO} means to concatenate triplets of features.
     */
    public enum ConcatenationScheme
    {
        ZERO,
        ONE,
        TWO
    }

    @PersistenceContext
    private EntityManager em;

    /**
     * Implementation of the Wordification algorithm for an entity with a specified id.
     *
     * @param rootEntity the root entity for which to compute the results of Wordification
     * @param idField the id field in the root entity
     * @param idValue the value of the id field in the root entity
     * @param entityNameToValueFields mapping of table names to properties for which to construct the features
     * @return {@code List} of obtained words for specified root entity
     */
    public List<String> wordify(String rootEntity, String idField, String idValue, Map<String, Set<String>> entityNameToValueFields, ValueTransformer valueTransformer, ConcatenationScheme concatenationScheme)
    {

        // list of resulting words
        List<String> wordsAll = new ArrayList<>();

        // Get root entity.
        String sql = String.format("SELECT e FROM %s e WHERE e.%s=%s", rootEntity, idField, idValue);
        Query query = em.createQuery(sql);
        Object root = query.getSingleResult();

        // Initialize set of visited tables.
        Set<String> visitedEntities = new HashSet<>();

        // Initialize BFS queue.
        Queue<Object> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);

        try
        {
            while (!bfsQueue.isEmpty())
            {

                // Get next entity from queue and get its simple class name.
                Object nxt = bfsQueue.remove();
                String entityName = nxt.getClass().getSimpleName();

                // Add to set of visited entities.
                visitedEntities.add(entityName);

                // Initialize list for words obtained from next table.
                List<String> wordsForEntity = new ArrayList<>();

                // Go over entity's properties.
                for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(nxt.getClass()).getPropertyDescriptors())
                {

                    Object nxtProperty = propertyDescriptor.getReadMethod().invoke(nxt);

                    // if property should be included as a word
                    if (entityNameToValueFields.containsKey(entityName) && entityNameToValueFields.get(entityName).contains(propertyDescriptor.getName()))
                    {
                        wordsForEntity.add(String.format("%s_%s_%s", entityName, propertyDescriptor.getName(), valueTransformer.applyTransform(entityName, propertyDescriptor.getName(), nxtProperty)).toLowerCase());
                    }
                    // if property collection of linked entities
                    else if (nxtProperty instanceof Collection && !((Collection<?>) nxtProperty).isEmpty())
                    {
                        Class<?> aClass = ((Collection<?>) nxtProperty).iterator().next().getClass();

                        // If collection of linked entities that were not yet visited, add to queue.
                        if (!visitedEntities.contains(aClass.getSimpleName()) && aClass.isAnnotationPresent(Table.class))
                        {
                            bfsQueue.addAll((Collection<?>) nxt);
                        }
                    }
                    else if (nxtProperty != null)
                    {

                        Class<?> aClass = nxtProperty.getClass();

                        // If property linked entity and not yet visited, add to queue.
                        if (!visitedEntities.contains(nxtProperty.getClass().getSimpleName()) && aClass.isAnnotationPresent(Table.class))
                        {
                            bfsQueue.add(nxtProperty);
                        }
                    }
                }

                // Add all words and concatenations for entity to results list.
                wordsAll.addAll(addConcatenations(wordsForEntity, concatenationScheme));
            }
        }
        catch (IntrospectionException | IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }

        return wordsAll;
    }

    /**
     * Construct word concatenation features from list of provided words and return list of original words with
     * concatenations appended.
     *
     * @param words {@code List} of words for which to add concatenations
     * @param concatenationScheme which concatenation schema to use
     */
    private List<String> addConcatenations(List<String> words, ConcatenationScheme concatenationScheme)
    {

        List<String> wordsWithConcatenations = new ArrayList<>(words);

        switch (concatenationScheme)
        {

            case ZERO -> {
            }

            case ONE -> addConcatenationsOne(words, wordsWithConcatenations);

            case TWO -> {
                addConcatenationsOne(words, wordsWithConcatenations);
                addConcatenationsTwo(words, wordsWithConcatenations);
            }

        }
        return wordsWithConcatenations;
    }

    /**
     * Add t_p_v__t_p'_v' type composite words.
     */
    public void addConcatenationsOne(List<String> words, List<String> wordsWithConcatenations)
    {
        for (int i = 0; i < words.size() - 1; i++)
        {
            for (int j = i + 1; j < words.size(); j++)
            {
                wordsWithConcatenations.add(String.format("%s__%s", words.get(i), words.get(j)));
            }
        }
    }

    /**
     * Add t_p_v__t_p'_v'__t_p''_v'' type composite words.
     */
    public void addConcatenationsTwo(List<String> words, List<String> wordsWithConcatenations)
    {
        for (int i = 0; i < words.size() - 2; i++)
        {
            for (int j = i + 1; j < words.size() - 1; j++)
            {
                for (int k = j + 1; k < words.size(); k++)
                {
                    wordsWithConcatenations.add(String.format("%s__%s__%s", words.get(i), words.get(j), words.get(k)));
                }
            }
        }
    }

}
