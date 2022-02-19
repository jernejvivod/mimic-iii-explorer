package si.jernej.mexplorer.core.manager;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

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

    public PatientsEntity getFirst()
    {
       TypedQuery<PatientsEntity> query = getEntityManager().createQuery("SELECT p FROM PatientsEntity p WHERE p.rowId=:id", PatientsEntity.class);
       query.setParameter("id", 9467);
       return query.getSingleResult();
    }
}
