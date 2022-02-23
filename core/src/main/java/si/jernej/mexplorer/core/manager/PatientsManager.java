package si.jernej.mexplorer.core.manager;

import javax.ejb.Stateless;

import si.jernej.mexplorer.core.data.query.QueryParam;
import si.jernej.mexplorer.core.data.query.QueryResult;
import si.jernej.mexplorer.entity.PatientsEntity;

@Stateless
public class PatientsManager extends AbstractManager<PatientsEntity>
{
    public QueryResult<PatientsEntity> getAll(QueryParam queryParam)
    {
        final String sql = "SELECT p FROM PatientsEntity p ";
        queryParam.setSelectInTwoSteps(true);
        return getAll(queryParam, sql, "p");
    }
}
