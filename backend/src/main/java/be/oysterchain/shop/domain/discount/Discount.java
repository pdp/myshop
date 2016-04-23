package be.oysterchain.shop.domain.discount;

import be.oysterchain.shop.domain.common.AbstractDomainObject;
import be.oysterchain.shop.domain.product.Product;
import com.google.common.base.Objects;

import javax.persistence.*;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE")
    private Date startDate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", nullable = false)
    private Product product;

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

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
