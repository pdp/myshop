package be.oysterchain.shop.domain.product;

import be.oysterchain.shop.domain.AbstractDomainObject;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import be.oysterchain.shop.domain.discount.Discount;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PRODUCT")
@DiscriminatorColumn(name = "PRODUCT_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Product extends AbstractDomainObject {

    @NotNull
    @Column(name = "CODE")
    private String code;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @Lob
    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ProductStatus status;

    public Product() {
    }

/*    @Column(name = "PRODUCT_TYPE")
    private String productType;*/

   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private Set<ProductPrice> productPrices;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discount", fetch = FetchType.LAZY)
    private Set<Discount> discounts;*/

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

/*    public Set<ProductPrice> getProductPrices() {
        if(productPrices == null) {
            productPrices = Sets.newHashSet();
        }
        return productPrices;
    }*/

/*    public void addProductPrice(ProductPrice productPrice) {
        getProductPrices().add(productPrice);
        productPrice.setProduct(this);
    }*/


/*    public Set<Discount> getDiscounts() {
        if(discounts == null) {
            discounts = Sets.newHashSet();
        }
        return discounts;
    }*/

/*    public void addDiscount(Discount discount) {
        getDiscounts().add(discount);
        discount.setProduct(this);
    }*/

/*    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }*/

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }

        if(!(object instanceof Product)) {
            return false;
        }

        Product other = (Product) object;

        return Objects.equal(code, other.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public String toString() {
        return String.format("Product code [%s], name [%s], description [%s], status [%s]", code, name, description, status);
    }
}
