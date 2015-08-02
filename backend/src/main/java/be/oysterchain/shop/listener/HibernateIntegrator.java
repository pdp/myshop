package be.oysterchain.shop.listener;

import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 * peter
 * 28.07.15
 */
public class HibernateIntegrator implements Integrator {
    @Override
    public void integrate(Configuration configuration, SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
        final EventListenerRegistry registry = serviceRegistry.getService(EventListenerRegistry.class);
        registry.appendListeners(EventType.PRE_INSERT, PreInsertAuditEventListener.class);
        registry.appendListeners(EventType.PRE_UPDATE, PreUpdateAuditEventListener.class);
    }

    @Override
    public void integrate(MetadataImplementor metadata, SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
        // do nothing
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
        // do nothing
    }
}
