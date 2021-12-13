package application.rest.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mult")
public class MultiplyAPI {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(@QueryParam("operands") String parameters) {
        return Router.route("mult", parameters);
    }
}
