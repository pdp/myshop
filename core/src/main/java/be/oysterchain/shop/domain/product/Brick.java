package be.oysterchain.shop.domain.product;

import javax.persistence.*;

/**
 * peter
 * 27.07.15
 */
@Entity
@Table(name = "BRICK")
@DiscriminatorValue(value = "BRICK")
@PrimaryKeyJoinColumn(name = "ID")
public class Brick extends Product {


    @Column(name = "HEIGHT")
    private int height;

    public Brick() {
        super();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Product code [%s], name [%s], description [%s], status [%s], height [%s]", getCode(), getName(), getDescription(), getStatus(), height);
    }
}
