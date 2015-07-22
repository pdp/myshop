package domain.discount;

import com.google.common.base.Objects;
import domain.AbstractDomainObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

import static com.google.common.base.Objects.equal;

/**
 * peter
 * 22.07.15
 */
@Entity
@Table(name = "DISCOUNT")
public class Discount extends AbstractDomainObject {

    @NotNull
    @Column(name = "DISCOUNT_TYPE")
    @Enumerated
    private DiscountType discountType;

    @NotNull
    @Column(name = "VALUE")
    private BigDecimal value;

    @NotNull
    @Column(name = "START_DATE")
    private Date startDate;

    @NotNull
    @Column(name = "END_DATE")
    private Date endDate;

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }

        if(!(object instanceof Discount)) {
            return false;
        }

        Discount other = (Discount) object;

        return equal(discountType, other.discountType) && equal(value, other.value) && equal(startDate, other.startDate) && equal(endDate, other.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(discountType, value, startDate, endDate);
    }

    @Override
    public String toString() {
        return String.format("Discount discounttype [%s], value [%s], startDate [%s], endDate [%s]", discountType, value, startDate, endDate);
    }
}
