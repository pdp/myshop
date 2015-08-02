package be.oysterchain.shop.listener;

import be.oysterchain.shop.domain.AbstractDomainObject;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.joda.time.DateTime;

/**
 * peter
 * 28.07.15
 */
public class PreUpdateAuditEventListener implements PreUpdateEventListener{

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        Object entity = event.getEntity();
        if(entity instanceof AbstractDomainObject) {
            ((AbstractDomainObject) entity).setLastModifiedOn(new DateTime().toDate());
        }
        return false;
    }
}
