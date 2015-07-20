package dao.product;

import domain.Product;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * peter
 * 20.07.15
 */
public class ShopLauncher {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-application.xml");

        ProductDao productDao = context.getBean(ProductDao.class);

        Product product = new Product();
        product.setCode("A45001KLM");
        product.setName("Kapstok");
        product.setDescription("Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten Om op te zitten ");
        productDao.save(product);


        System.out.println("Product::" + product.toString());

        //close resources
        context.close();
    }
}
