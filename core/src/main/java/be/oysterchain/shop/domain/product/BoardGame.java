package be.oysterchain.shop.domain.product;

import javax.persistence.*;

/**
 * peter
 * 25.07.15
 */
@Entity
@Table(name = "BOARD_GAME")
@DiscriminatorValue("BOARD_GAME")
@PrimaryKeyJoinColumn(name = "ID")
public class BoardGame extends Product {

    @Column
    private int numberOfPlayers;

    public BoardGame() {
        super();
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public String toString() {
        return String.format("Product code [%s], name [%s], description [%s], status [%s], number of players [%s]", getCode(), getName(), getDescription(), getStatus(), numberOfPlayers);
    }
}
