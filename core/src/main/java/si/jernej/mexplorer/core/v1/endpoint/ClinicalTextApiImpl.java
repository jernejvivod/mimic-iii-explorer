package si.jernej.mexplorer.core.v1.endpoint;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import org.jboss.ejb3.annotation.TransactionTimeout;

import si.jernej.mexplorer.core.service.ClinicalTextService;
import si.jernej.mexplorer.processorapi.v1.api.ClinicalTextApi;
import si.jernej.mexplorer.processorapi.v1.model.ClinicalTextConfigDto;
import si.jernej.mexplorer.processorapi.v1.model.ClinicalTextResultDto;

@Stateless
public class ClinicalTextApiImpl implements ClinicalTextApi
{
    @Inject
    private ClinicalTextService clinicalTextService;
    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionTimeout(value = 60, unit = TimeUnit.MINUTES)
    public Response clinicalText(ClinicalTextConfigDto clinicalTextConfigDto)
    {
        Set<ClinicalTextResultDto> extractedText = clinicalTextService.joinClinicalTextForEntity(
                clinicalTextService.extractClinicalText(clinicalTextConfigDto, em)
        );
        return Response.ok().entity(extractedText).build();
    }
}
