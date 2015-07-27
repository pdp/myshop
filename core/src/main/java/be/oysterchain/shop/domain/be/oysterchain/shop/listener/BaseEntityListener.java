package be.oysterchain.shop.domain.be.oysterchain.shop.listener;

import be.oysterchain.shop.domain.AbstractDomainObject;
import org.joda.time.DateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * peter
 * 27.07.15
 */
public class BaseEntityListener {

    @PrePersist
    public void setCreationData(AbstractDomainObject abstractDomainObject) {
        abstractDomainObject.setCreatedOn(new Date());
        abstractDomainObject.setLastModifiedOn(new Date());
    }

    @PreUpdate
    public void setUpdateData(AbstractDomainObject abstractDomainObject) {
        abstractDomainObject.setLastModifiedOn(new Date());
    }
}
