package si.jernej.mexplorer.core.test.service;

import java.util.List;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import si.jernej.mexplorer.core.exception.ValidationCoreException;
import si.jernej.mexplorer.core.manager.MimicEntityManager;
import si.jernej.mexplorer.core.processing.TargetExtraction;
import si.jernej.mexplorer.core.service.PropositionalizationService;
import si.jernej.mexplorer.processorapi.v1.model.ConcatenationSpecDto;
import si.jernej.mexplorer.processorapi.v1.model.PropertySpecDto;
import si.jernej.mexplorer.processorapi.v1.model.RootEntitiesSpecDto;
import si.jernej.mexplorer.processorapi.v1.model.WordificationConfigDto;
import si.jernej.mexplorer.processorapi.v1.model.WordificationResultDto;
import si.jernej.mexplorer.test.ATestBase;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PropositionalizationServiceTest extends ATestBase
{
    @Override
    protected Weld loadWeld(Weld weld)
    {
        return weld.addPackages(
                true,
                getClass(),
                PropositionalizationService.class,
                TargetExtraction.class,
                MimicEntityManager.class
        );
    }

    @Inject
    private PropositionalizationService propositionalizationService;

    @Test
    public void testComputeWoridificationWrongEntity()
    {
        WordificationConfigDto wordificationConfigDto = new WordificationConfigDto();
        RootEntitiesSpecDto rootEntitiesSpecDto = new RootEntitiesSpecDto();
        rootEntitiesSpecDto.setRootEntity("Wrong");
        rootEntitiesSpecDto.setIdProperty("wrong");
        rootEntitiesSpecDto.setIds(List.of(100001L));
        wordificationConfigDto.setRootEntitiesSpec(rootEntitiesSpecDto);
        Assertions.assertThrows(ValidationCoreException.class, () -> propositionalizationService.computeWordification(wordificationConfigDto));
    }

    @Test
    public void testComputeWoridificationWrongIdProperty()
    {
        WordificationConfigDto wordificationConfigDto = new WordificationConfigDto();
        RootEntitiesSpecDto rootEntitiesSpecDto = new RootEntitiesSpecDto();
        rootEntitiesSpecDto.setRootEntity("AdmissionsEntity");
        rootEntitiesSpecDto.setIdProperty("wrong");
        rootEntitiesSpecDto.setIds(List.of(100001L));
        wordificationConfigDto.setRootEntitiesSpec(rootEntitiesSpecDto);
        Assertions.assertThrows(ValidationCoreException.class, () -> propositionalizationService.computeWordification(wordificationConfigDto));
    }

    @Test
    public void testComputeWordificationEmptyPropertySpec()
    {
        WordificationConfigDto wordificationConfigDto = new WordificationConfigDto();

        RootEntitiesSpecDto rootEntitiesSpecDto = new RootEntitiesSpecDto();
        rootEntitiesSpecDto.setRootEntity("AdmissionsEntity");
        rootEntitiesSpecDto.setIdProperty("hadmId");
        rootEntitiesSpecDto.setIds(List.of(100001L));

        wordificationConfigDto.setRootEntitiesSpec(rootEntitiesSpecDto);

        PropertySpecDto propertySpecDto = new PropertySpecDto();
        wordificationConfigDto.setPropertySpec(propertySpecDto);

        ConcatenationSpecDto concatenationSpecDto = new ConcatenationSpecDto();
        concatenationSpecDto.setConcatenationScheme(ConcatenationSpecDto.ConcatenationSchemeEnum.ZERO);

        wordificationConfigDto.setConcatenationSpec(concatenationSpecDto);

        List<WordificationResultDto> results = propositionalizationService.computeWordification(wordificationConfigDto);
        results.forEach(r -> Assertions.assertTrue(r.getWords().isEmpty()));
    }

    @Test
    public void testComputeWoridificationSimple()
    {
        // TODO
    }

    @Test
    public void testComputeWordificationFull()
    {
        // TODO
    }

}
