package si.jernej.mexplorer.core.v1.endpoint;

import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import si.jernej.mexplorer.core.service.ClinicalTextService;
import si.jernej.mexplorer.processorapi.v1.api.ClinicalTextApi;
import si.jernej.mexplorer.processorapi.v1.model.ClinicalTextConfigDto;
import si.jernej.mexplorer.processorapi.v1.model.ClinicalTextResultDto;

@Stateless
public class ClinicalTextApiImpl implements ClinicalTextApi
{
    @Inject
    private ClinicalTextService clinicalTextService;

    @Override
    public Response clinicalText(ClinicalTextConfigDto clinicalTextConfigDto)
    {
        Set<ClinicalTextResultDto> extractedText = clinicalTextService.extractClinicalText(clinicalTextConfigDto);
        return Response.ok().entity(extractedText).build();
    }
}
