package be.oysterchain.shop.listener;

import be.oysterchain.shop.domain.common.AbstractDomainObject;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.joda.time.DateTime;

/**
 * peter
 * 27.07.15
 */
public class PreInsertAuditEventListener implements PreInsertEventListener {


    public boolean onPreInsert(PreInsertEvent event) {
        Object entity = event.getEntity();
        if(entity instanceof AbstractDomainObject) {
            DateTime dateTime = new DateTime();
            ((AbstractDomainObject) entity).setCreatedOn(dateTime.toDate());
            ((AbstractDomainObject) entity).setLastModifiedOn(dateTime.toDate());
        }
        return false;
    }
}
