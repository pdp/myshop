package be.oysterchain.shop.domain.product;

import javax.persistence.*;

/**
 * peter
 * 25.07.15
 */
@Entity
@Table(name = "PRODUCT")
@DiscriminatorColumn(name = "PRODUCT_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "BOARD_GAME")
public class BoardGame extends Product {

}
