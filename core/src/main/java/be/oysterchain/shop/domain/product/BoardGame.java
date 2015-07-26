package be.oysterchain.shop.domain.product;

import javax.persistence.*;

/**
 * peter
 * 25.07.15
 */
@Entity
@DiscriminatorValue(value = "BOARD_GAME")
public class BoardGame extends Product {

}
