package application.rest.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import application.utils.APIUtils;

@Path("/div")
public class DivisionAPI {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response divide(@QueryParam("operands") String parameters) {
        Router router = APIUtils.getRouter();
        return router.calculate("div", parameters);
    }
}
