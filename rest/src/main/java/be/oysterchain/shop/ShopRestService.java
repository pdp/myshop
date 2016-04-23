package be.oysterchain.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/message")
@Service
public class ShopRestService {

    @Autowired
    private OrderService orderService;


    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg) {
        Product
//        Product product = orderService.find(1L);
        String result = "Restful example : " + msg;

        return Response.status(200).entity(result).build();

    }

}
