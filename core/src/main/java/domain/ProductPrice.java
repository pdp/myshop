package domain;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PRODUCT_PRICE")
public class ProductPrice extends AbstractDomainObject  {

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

    @Override
    public String toString() {
        return String.format("Productprice value [%s], startDate [%s], endDate [%s], status", value, startDate, endDate, status);
    }

}
