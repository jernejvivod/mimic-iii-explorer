package si.jernej.mexplorer.core.v1.endpoint;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import si.jernej.mexplorer.core.service.ClinicalTextService;
import si.jernej.mexplorer.processorapi.v1.api.ClinicalTextApi;
import si.jernej.mexplorer.processorapi.v1.model.ClinicalTextConfigDto;

@Stateless
public class ClinicalTextApiImpl implements ClinicalTextApi
{
    @Inject
    private ClinicalTextService clinicalTextService;

    @Override
    public Response clinicalText(ClinicalTextConfigDto clinicalTextConfigDto)
    {
        return Response.ok().entity(clinicalTextService.extractClinicalText(clinicalTextConfigDto)).build();
    }
}
