package domain.product;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import domain.AbstractDomainObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
    @Enumerated
    private ProductStatus status;

    private String productType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<ProductPrice> productPrices;

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

    public Set<ProductPrice> getProductPrices() {
        if(productPrices == null) {
            productPrices = Sets.newHashSet();
        }
        return productPrices;
    }

    public void addProductPrice(ProductPrice productPrice) {
        getProductPrices().add(productPrice);
        productPrice.setProduct(this);
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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
        return String.format("Product code [%s], name [%s], description [%s]", code, name, description);
    }
}
