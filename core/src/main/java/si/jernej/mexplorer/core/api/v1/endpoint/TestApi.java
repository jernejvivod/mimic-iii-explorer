package si.jernej.mexplorer.core.api.v1.endpoint;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("test")
public interface TestApi
{

    @POST
    @Path("doTest/{id}")
    void test(@PathParam("id") String id);

}
