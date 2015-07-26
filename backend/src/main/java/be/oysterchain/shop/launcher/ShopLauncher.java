package be.oysterchain.shop.launcher;

import be.oysterchain.shop.domain.product.BoardGame;
import be.oysterchain.shop.domain.product.ProductStatus;
import be.oysterchain.shop.product.ProductDao;
import be.oysterchain.shop.domain.product.Product;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * peter
 * 20.07.15
 */
public class ShopLauncher {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hibernate.cfg.xml");

        ProductDao productDao = context.getBean(ProductDao.class);

        Product boardGame = new BoardGame();
        boardGame.setCode("A45001KLM");
        boardGame.setName("Klote hibernate");
        boardGame.setDescription("Om op te zitten");
        boardGame.setStatus(ProductStatus.AVAILABLE);
        productDao.save(boardGame);


        System.out.println("Product::" + boardGame.toString());

        //close resources
        context.close();
    }
}
