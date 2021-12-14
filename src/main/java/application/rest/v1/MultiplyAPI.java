package application.rest.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import application.utils.APIUtils;

@Path("/mult")
public class MultiplyAPI {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response multiply(@QueryParam("operands") String parameters) {
        Router router = APIUtils.getRouter();
        return router.calculate("mult", parameters);
    }
}
