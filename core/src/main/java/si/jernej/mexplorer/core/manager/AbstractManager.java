package si.jernej.mexplorer.core.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.jernej.mexplorer.core.data.query.QueryParam;
import si.jernej.mexplorer.core.data.query.QueryResult;

public class AbstractManager<T> implements Serializable
{
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager()
    {
        return em;
    }

    protected QueryResult<T> getAll(QueryParam queryParam, String sqlQuery, String rootEntity)
    {
        String sqlCount = buildSqlForCount(sqlQuery, rootEntity);

        List<T> list = new ArrayList<>();
        if (queryParam.getItemsPerPage() > 0)
        {
            list = getListResult(queryParam, sqlQuery, rootEntity);
        }

        return new QueryResult<>(list, queryParam.isSelectInTwoSteps());
    }

    protected List<T> getListResult(QueryParam queryParam, String sqlQuery, String rootEntity)
    {
        // TODO Jernej
        return null;
    }

    protected String buildSqlForCount(String sqlQuery, String rootEntity)
    {
        // TODO Jernej
        return null;
    }

}
