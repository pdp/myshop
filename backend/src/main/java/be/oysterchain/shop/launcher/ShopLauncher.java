package be.oysterchain.shop.launcher;

import be.oysterchain.shop.domain.product.BoardGame;
import be.oysterchain.shop.domain.product.Brick;
import be.oysterchain.shop.domain.product.ProductStatus;
import be.oysterchain.shop.dao.product.ProductDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * peter
 * 20.07.15
 */
public class ShopLauncher {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/backend-application-context.xml");

        ProductDao productDao = context.getBean(ProductDao.class);

        BoardGame boardGame = new BoardGame();
        boardGame.setCode("A45001KLM");
        boardGame.setName("Klote hibernate");
        boardGame.setDescription("Om op te zitten");
        boardGame.setStatus(ProductStatus.AVAILABLE);
        boardGame.setNumberOfPlayers(5);
        productDao.save(boardGame);

        System.out.println("Boardgame::" + boardGame.toString());

        Brick brick = new Brick();
        brick.setCode("BBB");
        brick.setName("Sucking hibernate");
        brick.setDescription("Om te spelen");
        brick.setStatus(ProductStatus.NEW);
        brick.setHeight(15);
        productDao.save(brick);


        System.out.println("Brick::" + brick.toString());

        //close resources
        context.close();
    }
}
