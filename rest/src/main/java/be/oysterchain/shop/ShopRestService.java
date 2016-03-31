package src.main.java.be.oysterchain.shop;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/hello")
public class ShopRestService {
    @GET
    @Path("/sayHello/{user}")
    public Response dispMessage(@PathParam("user") String msg) {
        String message = "Welcome " + msg + "!!!";

        return Response.status(200).entity(message).build();

    }
}
