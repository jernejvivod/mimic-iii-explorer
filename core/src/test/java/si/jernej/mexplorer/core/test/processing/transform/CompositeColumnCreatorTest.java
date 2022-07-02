package si.jernej.mexplorer.core.test.processing.transform;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import si.jernej.mexplorer.core.util.EntityUtils;

class CompositeColumnCreatorTest
{
    @Test
    void testForeignPathComputation()
    {
        Map<String, Set<String>> entityToLinkedEntities = Map.ofEntries(
                Map.entry("A", Set.of("B", "C", "D")),
                Map.entry("B", Set.of("A")),
                Map.entry("C", Set.of("A", "E")),
                Map.entry("D", Set.of("A", "F", "G")),
                Map.entry("E", Set.of("C")),
                Map.entry("F", Set.of("D", "I")),
                Map.entry("G", Set.of("D", "H")),
                Map.entry("H", Set.of("G", "I")),
                Map.entry("I", Set.of("F", "H"))
        );

        List<String> fkp1 = EntityUtils.computeForeignKeyPath("A", "A", entityToLinkedEntities);
        List<String> fkp2 = EntityUtils.computeForeignKeyPath("A", "B", entityToLinkedEntities);
        List<String> fkp3 = EntityUtils.computeForeignKeyPath("A", "E", entityToLinkedEntities);
        List<String> fkp4 = EntityUtils.computeForeignKeyPath("A", "I", entityToLinkedEntities);

        Assertions.assertEquals(fkp1, List.of("A"));
        Assertions.assertEquals(fkp2, List.of("A", "B"));
        Assertions.assertEquals(fkp3, List.of("A", "C", "E"));
        Assertions.assertEquals(fkp4, List.of("A", "D", "F", "I"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> EntityUtils.computeForeignKeyPath("A", "NONEXISTENT", entityToLinkedEntities));
        Assertions.assertThrows(IllegalArgumentException.class, () -> EntityUtils.computeForeignKeyPath("NONEXISTENT", "NONEXISTENT", entityToLinkedEntities));
    }
}
