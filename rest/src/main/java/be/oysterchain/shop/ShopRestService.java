package be.oysterchain.shop;

import be.oysterchain.shop.domain.product.Product;
import be.oysterchain.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/message")
public class ShopRestService {

    @Autowired
    private OrderService orderService;

    public ShopRestService() {

    }


    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/backend-application-context.xml");

        OrderService orderService = context.getBean(OrderService.class);

        if(orderService == null) {
            msg = "orderservice is null";
        } else {
            Product product = orderService.find(1L);
            if(product == null){
                msg = "product is null";
            } else {
                msg = product.getName();
            }
        }

        String result = "Restful example : " + msg;

        return Response.status(200).entity(result).build();

    }

}
