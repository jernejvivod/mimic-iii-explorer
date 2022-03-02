package si.jernej.mexplorer.core.manager;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import si.jernej.mexplorer.entity.AdmissionsEntity;

@Stateless
public class AdmissionsManager extends AbstractManager<AdmissionsEntity>
{
    public AdmissionsEntity getFirst()
    {
        TypedQuery<AdmissionsEntity> query = getEntityManager().createQuery("SELECT a FROM AdmissionsEntity a WHERE a.rowId=:id", AdmissionsEntity.class);
        query.setParameter("id", 12258);
        return query.getSingleResult();
    }
}
