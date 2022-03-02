package si.jernej.mexplorer.core.transform;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class implementing functionality for creating composite columns.
 */
public class CompositeColumnCreator
{

    /**
     * Record representing a specification entry for the creation of a composite column.
     */
    private record Entry(List<String> foreignKeyPath1, String property1, List<String> foreignKeyPath2, String property2, String compositeName, BiFunction<Object, Object, Object> combiner)
    {

        public List<String> getForeignKeyPath1()
        {
            return foreignKeyPath1;
        }

        public List<String> getForeignKeyPath2()
        {
            return foreignKeyPath2;
        }

        public String getProperty1()
        {
            return property1;
        }

        public String getProperty2()
        {
            return property2;
        }

        public String getCompositeName()
        {
            return compositeName;
        }

        public BiFunction<Object, Object, Object> getCombiner()
        {
            return combiner;
        }
    }

    private final List<Entry> entries;

    public CompositeColumnCreator()
    {
        this.entries = new ArrayList<>();
    }

    /**
     * Add specification entry for a composite column creation.
     *
     * @param foreignKeyPath1 foreign key path to the first property constituting the composite column
     * @param property1 name of first property constituting the composite column
     * @param foreignKeyPath2 foreign key path to the second property constituting the composite column
     * @param property2 name of second property constituting the composite column
     * @param compositeName name of the new composite property
     * @param combiner BiFunction instance used to combine the property columns forming the composite column
     */
    public void addEntry(List<String> foreignKeyPath1, String property1, List<String> foreignKeyPath2, String property2, String compositeName, BiFunction<Object, Object, Object> combiner)
    {
        entries.add(new Entry(foreignKeyPath1, property1, foreignKeyPath2, property2, compositeName, combiner));
    }

    /**
     * Create composite columns in new table as specified by the added entries.
     *
     * @param rootEntities List of root entities
     * @return List of created composite columns in order of specified entries
     */
    public Map<String, List<Object>> processEntries(List<Object> rootEntities)
    {

        // set columns in new table for entity
        Map<String, List<Object>> resultsForEntity = new HashMap<>();

        // Go over entries.
        for (Entry entry : entries)
        {

            // Initialize lists for column values to be combined.
            List<Object> res1Prop = new ArrayList<>();
            List<Object> res2Prop = new ArrayList<>();

            try
            {

                // Get first list of entities containing the property to be combined.
                List<Object> res1 = rootEntities;
                for (String s : entry.getForeignKeyPath1())
                {
                    List<Object> resNxt = new ArrayList<>();
                    for (Object r : res1)
                    {
                        resNxt.add(new PropertyDescriptor(s, r.getClass()).getReadMethod().invoke(r));
                    }
                    res1 = resNxt;
                }

                // Get second list of entities containing the property to be combined.
                List<Object> res2 = rootEntities;
                for (String s : entry.getForeignKeyPath2())
                {
                    List<Object> resNxt = new ArrayList<>();
                    for (Object r : res2)
                    {
                        resNxt.add(new PropertyDescriptor(s, r.getClass()).getReadMethod().invoke(r));
                    }
                    res2 = resNxt;
                }

                // Get list of property values for both columns forming the composite column.
                for (Object r : res1)
                {
                    res1Prop.add(new PropertyDescriptor(entry.getProperty1(), r.getClass()).getReadMethod().invoke(r));
                }

                for (Object r : res2)
                {
                    res2Prop.add(new PropertyDescriptor(entry.getProperty2(), r.getClass()).getReadMethod().invoke(r));
                }
            }
            catch (IntrospectionException | IllegalAccessException | InvocationTargetException e)
            {
                return new HashMap<>();
            }

            if (res1Prop.size() != res2Prop.size())
            {
                throw new IllegalArgumentException("Size of columns forming the composite column is not equal.");
            }

            // Combine properties of entities.
            resultsForEntity.put(entry.getCompositeName(), IntStream.range(0, res1Prop.size()).mapToObj(i -> entry.combiner.apply(res1Prop.get(i), res2Prop.get(i))).collect(Collectors.toList()));
        }

        return resultsForEntity;
    }

}