package si.jernej.mexplorer.core.processing.spec;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import si.jernej.mexplorer.core.exception.ValidationCoreException;

/**
 * Class representing the specification of which properties of which entities to include for the
 * Wordification algorithm.
 */
public class PropertySpec
{
    private final Map<String, Set<String>> entityToPropertiesToProcess;
    private final Map<String, String> sortSpecs;

    public PropertySpec()
    {
        this.entityToPropertiesToProcess = new HashMap<>();
        this.sortSpecs = new HashMap<>();
    }

    /**
     * Add entry to the specification.
     *
     * @param entity name of entity
     * @param property name of the entity's property
     */
    public void addEntry(String entity, String property)
    {
        entityToPropertiesToProcess.computeIfAbsent(entity, e -> new HashSet<>()).add(property);
    }

    /**
     * Add entries to the specification.
     *
     * @param entity name of entity
     * @param properties name of entity's property
     */
    public void addEntry(String entity, Collection<String> properties)
    {
        entityToPropertiesToProcess.computeIfAbsent(entity, e -> new HashSet<>()).addAll(properties);
    }

    /**
     * Check if property name for entity specified.
     *
     * @param entity name of entity
     * @param propertyName name of entity's property
     * @return is the entity's property specified to be part of the Wordification algorithm's output
     */
    public boolean containsEntry(String entity, String propertyName)
    {
        return this.entityToPropertiesToProcess.containsKey(entity) && this.entityToPropertiesToProcess.get(entity).contains(propertyName);
    }

    /**
     * Add sort specification
     *
     * @param entity entity for which to apply the sorting
     * @param property the property by which to sort
     */
    public void addSort(String entity, String property)
    {
        this.sortSpecs.put(entity, property);
    }

    /**
     * Check if the entity contains a sort specification
     *
     * @param entity name of entity
     */
    public boolean containsSort(String entity)
    {
        return this.sortSpecs.containsKey(entity);
    }

    /**
     * Get sort property for entity
     *
     * @param entity name of entity
     */
    public String getSortProperty(String entity)
    {
        return Optional.ofNullable(this.sortSpecs.get(entity))
                .orElseThrow(() -> new ValidationCoreException("No sort property specified for entity '%s'".formatted(entity)));
    }

}
