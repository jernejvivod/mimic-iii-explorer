package si.jernej.mexplorer.core.manager;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractManager<T> implements Serializable
{
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager()
    {
        return em;
    }

}
