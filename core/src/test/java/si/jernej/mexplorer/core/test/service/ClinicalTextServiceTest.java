package si.jernej.mexplorer.core.test.service;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import si.jernej.mexplorer.core.service.ClinicalTextService;
import si.jernej.mexplorer.processorapi.v1.model.ClinicalTextConfigDto;
import si.jernej.mexplorer.processorapi.v1.model.RootEntitiesSpecDto;
import si.jernej.mexplorer.test.ATestBase;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClinicalTextServiceTest extends ATestBase
{
    // @Inject
    // ClinicalTextService clinicalTextService;

    @Test
    void extractEmptyIdList()
    {
        ClinicalTextConfigDto clinicalTextConfigDto = new ClinicalTextConfigDto();
        RootEntitiesSpecDto rootEntitiesSpecDto = new RootEntitiesSpecDto();
        rootEntitiesSpecDto.setRootEntity("AdmissionsEntity");
        rootEntitiesSpecDto.setIdProperty("hadmId");
        rootEntitiesSpecDto.setIds(List.of());
        clinicalTextConfigDto.setRootEntitiesSpec(rootEntitiesSpecDto);

        // clinicalTextService.extractClinicalText(clinicalTextConfigDto);
    }
}
