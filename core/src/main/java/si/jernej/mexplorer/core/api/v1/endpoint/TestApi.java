package si.jernej.mexplorer.core.api.v1.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("test")
public interface TestApi
{

    @GET
    @Path("test-wordification/{id}")
    Response testWordification(@PathParam("id") String id);

    @GET
    @Path("test-composite-column-creator/{id}")
    Response testCompositeColumnCreator(@PathParam("id") String id);

}
