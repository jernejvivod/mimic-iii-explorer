package si.jernej.mexplorer.core.api.v1.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("test")
public interface TestApi
{

    @GET
    @Path("doTest/{id}")
    Response test(@PathParam("id") String id);

}
