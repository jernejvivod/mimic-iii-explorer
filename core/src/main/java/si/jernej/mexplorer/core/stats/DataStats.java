package si.jernej.mexplorer.core.stats;

import static si.jernej.mexplorer.core.util.Constants.NUMBER_UNIQUE_NAME;
import static si.jernej.mexplorer.core.util.Constants.PORTION_NULL_NAME;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class DataStats
{

    @PersistenceContext
    private EntityManager em;

    public Map<String, Number> getColumnStats(String entityName, String columnName)
    {

        // Initialize Map for results.
        Map<String, Number> results = new HashMap<>();

        // Get list of values for which to compute statistics.
        String sql = String.format("SELECT e.%s FROM %s e", columnName, entityName);
        Query query = em.createQuery(sql);
        List<?> res = query.getResultList();

        // 1. PORTION OF NULL VALUES
        results.put(PORTION_NULL_NAME, res.size() / ((double) res.stream().filter(Objects::nonNull).count()));

        // 2. NUMBER OF UNIQUE VALUES
        results.put(NUMBER_UNIQUE_NAME, res.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).size());

        return results;
    }
}
