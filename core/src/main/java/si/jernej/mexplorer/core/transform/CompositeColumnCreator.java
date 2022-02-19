package si.jernej.mexplorer.core.transform;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Class implementing functionality for creating composite columns.
 */
public class CompositeColumnCreator
{

    /**
     * TODO
     * TODO Test
     */
    private record Entry(List<String> foreignKeyPath1, String property1, List<String> foreignKeyPath2, String property2, BiFunction<List<Object>, List<Object>, List<Object>> combiner)
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

        public BiFunction<List<Object>, List<Object>, List<Object>> getCombiner()
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
     * TODO
     *
     * @param foreignKeyPath1
     * @param property1
     * @param foreignKeyPath2
     * @param property2
     * @param combiner
     */
    public void addEntry(List<String> foreignKeyPath1, String property1, List<String> foreignKeyPath2, String property2, BiFunction<List<Object>, List<Object>, List<Object>> combiner)
    {
        entries.add(new Entry(foreignKeyPath1, property1, foreignKeyPath2, property2, combiner));
    }

    /**
     * TODO
     *
     * @param rootEntity
     * @return
     */
    public List<List<Object>> processEntries(Object rootEntity)
    {
        // Mapping from root entity to entities for first property to be combined.
        List<Object> entitiesForProperty1 = new ArrayList<>();

        // Mapping from root entity to entities for second property to be combined.
        List<Object> entitiesForProperty2 = new ArrayList<>();

        // Columns in new table for entity.
        List<List<Object>> resultsForEnty = new ArrayList<>();  // columns in new table

        // Go over entries.
        for (Entry entry : entries)
        {

            for (String s : entry.getForeignKeyPath1())
            {
                // Get
            }
            for (String s : entry.getForeignKeyPath2())
            {
                // Get
            }
            resultsForEnty.add(entry.combiner.apply(entitiesForProperty1, entitiesForProperty2));
        }

        return resultsForEnty;

    }

}
