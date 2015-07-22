package domain.product;

import com.google.common.base.Objects;
import domain.AbstractDomainObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

import static com.google.common.base.Objects.equal;

@Entity
@Table(name = "PRODUCT_PRICE")
public class ProductPrice extends AbstractDomainObject {

    @NotNull
    @Column(name = "VALUE")
    private BigDecimal value;

    @NotNull
    @Column(name = "START_DATE")
    private Date startDate;

    @NotNull
    @Column(name = "END_DATE")
    private Date endDate;

    @NotNull
    @Enumerated
    @Column(name = "PRODUCT_PRICE_STATUS")
    private ProductPriceStatus status;

    @JoinColumn(name = "ID", nullable = false)
    private Product product;

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

    public ProductPriceStatus getStatus() {
        return status;
    }

    public void setStatus(ProductPriceStatus status) {
        this.status = status;
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

        if(!(object instanceof ProductPrice)) {
            return false;
        }

        ProductPrice other = (ProductPrice) object;

        return equal(value, other.value) && equal(startDate, other.startDate) && equal(endDate, other.endDate) && equal(status, other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value, startDate, endDate, status);
    }

    @Override
    public String toString() {
        return String.format("Productprice value [%s], startDate [%s], endDate [%s], status", value, startDate, endDate, status);
    }

}
