package si.jernej.mexplorer.core.v1.endpoint;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;

import si.jernej.mexplorer.core.processing.IdRetrieval;
import si.jernej.mexplorer.processorapi.v1.api.IdsApi;
import si.jernej.mexplorer.processorapi.v1.model.IdRetrievalSpecDto;

@Stateless
public class IdsApiImpl implements IdsApi
{
    @Inject
    private IdRetrieval idRetrieval;

    @Override
    public Response ids(@Valid @NotNull IdRetrievalSpecDto idRetrievalSpecDto)
    {
        return Response.ok().entity(idRetrieval.retrieveIds(idRetrievalSpecDto)).build();
    }
}
