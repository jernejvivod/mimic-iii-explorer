package si.jernej.mexplorer.core.processing;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class representing the specification of which properties of which entities to include for the
 * Wordification algorithm.
 */
public class PropertySpec
{

    private final Map<String, Set<String>> entityToPropertiesToProcess;

    public PropertySpec()
    {
        this.entityToPropertiesToProcess = new HashMap<>();
    }

    /**
     * Add entry to the specification.
     *
     * @param entity name of entity
     * @param field name of the entity's property
     */
    public void addEntry(String entity, String field)
    {
        entityToPropertiesToProcess.computeIfAbsent(entity, e -> new HashSet<>()).add(field);
    }

    /**
     * Add entries to the specification.
     *
     * @param entity name of entity
     * @param fields name of entity's property
     */
    public void addEntry(String entity, Collection<String> fields)
    {
        entityToPropertiesToProcess.computeIfAbsent(entity, e -> new HashSet<>()).addAll(fields);
    }

}
