package si.jernej.mexplorer.core.v1.endpoint;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import si.jernej.mexplorer.core.service.TargetExtractionService;
import si.jernej.mexplorer.processorapi.v1.api.TargetApi;
import si.jernej.mexplorer.processorapi.v1.model.TargetExtractionSpecDto;

@Stateless
public class TargetApiImpl implements TargetApi
{
    @Inject
    private TargetExtractionService targetExtractionService;

    @Override
    public Response targetExtraction(TargetExtractionSpecDto targetExtractionSpecDto)
    {
        return Response.ok().entity(targetExtractionService.computeTarget(targetExtractionSpecDto)).build();
    }

}
