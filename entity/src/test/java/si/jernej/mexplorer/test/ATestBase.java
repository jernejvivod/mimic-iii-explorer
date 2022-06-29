package si.jernej.mexplorer.test;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.jboss.weld.junit5.auto.EnableAutoWeld;

@EnableAutoWeld
public class ATestBase
{
    @WeldSetup
    public WeldInitiator weld = WeldInitiator.from(WeldInitiator.createWeld().addPackages(true, getClass()))
            .inject(this)
            .activate(RequestScoped.class, SessionScoped.class)
            .setPersistenceUnitFactory(ip -> PersistenceContextManager.emFactory())
            .setPersistenceContextFactory(ip -> PersistenceContextManager.em())
            .build();

    @PersistenceContext
    protected EntityManager em;
}
