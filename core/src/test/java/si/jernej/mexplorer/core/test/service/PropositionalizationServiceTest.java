package si.jernej.mexplorer.core.test.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import si.jernej.mexplorer.core.exception.ValidationCoreException;
import si.jernej.mexplorer.core.manager.MimicEntityManager;
import si.jernej.mexplorer.core.processing.TargetExtraction;
import si.jernej.mexplorer.core.service.PropositionalizationService;
import si.jernej.mexplorer.processorapi.v1.model.CompositeColumnsSpecDto;
import si.jernej.mexplorer.processorapi.v1.model.CompositeColumnsSpecEntryDto;
import si.jernej.mexplorer.processorapi.v1.model.ConcatenationSpecDto;
import si.jernej.mexplorer.processorapi.v1.model.PropertySpecDto;
import si.jernej.mexplorer.processorapi.v1.model.PropertySpecEntryDto;
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
    public void testComputeWoridificationSimpleSingleEntity()
    {
        WordificationConfigDto wordificationConfigDto = new WordificationConfigDto();

        RootEntitiesSpecDto rootEntitiesSpecDto = new RootEntitiesSpecDto();
        rootEntitiesSpecDto.setRootEntity("AdmissionsEntity");
        rootEntitiesSpecDto.setIdProperty("hadmId");
        rootEntitiesSpecDto.setIds(List.of(100001L));

        wordificationConfigDto.setRootEntitiesSpec(rootEntitiesSpecDto);

        PropertySpecDto propertySpecDto = new PropertySpecDto();

        PropertySpecEntryDto propertySpecEntryDto = new PropertySpecEntryDto();
        propertySpecEntryDto.setEntity("AdmissionsEntity");
        propertySpecEntryDto.setProperties(List.of("insurance", "language", "religion"));
        propertySpecDto.addEntriesItem(propertySpecEntryDto);

        wordificationConfigDto.setPropertySpec(propertySpecDto);

        ConcatenationSpecDto concatenationSpecDto = new ConcatenationSpecDto();
        concatenationSpecDto.setConcatenationScheme(ConcatenationSpecDto.ConcatenationSchemeEnum.ZERO);

        wordificationConfigDto.setConcatenationSpec(concatenationSpecDto);

        List<WordificationResultDto> results = propositionalizationService.computeWordification(wordificationConfigDto);

        Set<String> expectedWords = Set.of(
                "admissionsentity@insurance@private",
                "admissionsentity@language@engl",
                "admissionsentity@religion@protestant_quaker"
        );

        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(expectedWords, new HashSet<>(results.get(0).getWords()));
    }

    @Test
    public void testComputeWoridificationSimpleTwoLinkedEntities()
    {
        WordificationConfigDto wordificationConfigDto = new WordificationConfigDto();

        RootEntitiesSpecDto rootEntitiesSpecDto = new RootEntitiesSpecDto();
        rootEntitiesSpecDto.setRootEntity("AdmissionsEntity");
        rootEntitiesSpecDto.setIdProperty("hadmId");
        rootEntitiesSpecDto.setIds(List.of(100001L));

        wordificationConfigDto.setRootEntitiesSpec(rootEntitiesSpecDto);

        PropertySpecDto propertySpecDto = new PropertySpecDto();

        PropertySpecEntryDto propertySpecEntryDto1 = new PropertySpecEntryDto();
        propertySpecEntryDto1.setEntity("AdmissionsEntity");
        propertySpecEntryDto1.setProperties(List.of("insurance", "language", "religion"));
        propertySpecDto.addEntriesItem(propertySpecEntryDto1);

        PropertySpecEntryDto propertySpecEntryDto2 = new PropertySpecEntryDto();
        propertySpecEntryDto2.setEntity("PatientsEntity");
        propertySpecEntryDto2.setProperties(List.of("gender", "expireFlag"));
        propertySpecDto.addEntriesItem(propertySpecEntryDto2);

        wordificationConfigDto.setPropertySpec(propertySpecDto);

        ConcatenationSpecDto concatenationSpecDto = new ConcatenationSpecDto();
        concatenationSpecDto.setConcatenationScheme(ConcatenationSpecDto.ConcatenationSchemeEnum.ZERO);

        wordificationConfigDto.setConcatenationSpec(concatenationSpecDto);

        List<WordificationResultDto> results = propositionalizationService.computeWordification(wordificationConfigDto);

        Set<String> expectedWords = Set.of(
                "admissionsentity@insurance@private",
                "admissionsentity@language@engl",
                "admissionsentity@religion@protestant_quaker",
                "patientsentity@expireflag@0",
                "patientsentity@gender@f"
        );

        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(expectedWords, new HashSet<>(results.get(0).getWords()));
    }

    @Test
    public void testComputeWoridificationSimpleTwoLinkedEntitiesWithCompositeColumns()
    {
        WordificationConfigDto wordificationConfigDto = new WordificationConfigDto();

        RootEntitiesSpecDto rootEntitiesSpecDto = new RootEntitiesSpecDto();
        rootEntitiesSpecDto.setRootEntity("AdmissionsEntity");
        rootEntitiesSpecDto.setIdProperty("hadmId");
        rootEntitiesSpecDto.setIds(List.of(100001L));

        wordificationConfigDto.setRootEntitiesSpec(rootEntitiesSpecDto);

        PropertySpecDto propertySpecDto = new PropertySpecDto();

        PropertySpecEntryDto propertySpecEntryDto1 = new PropertySpecEntryDto();
        propertySpecEntryDto1.setEntity("AdmissionsEntity");
        propertySpecEntryDto1.setProperties(List.of("insurance", "language", "religion"));
        propertySpecDto.addEntriesItem(propertySpecEntryDto1);

        PropertySpecEntryDto propertySpecEntryDto2 = new PropertySpecEntryDto();
        propertySpecEntryDto2.setEntity("PatientsEntity");
        propertySpecEntryDto2.setProperties(List.of("gender", "expireFlag"));
        propertySpecDto.addEntriesItem(propertySpecEntryDto2);

        wordificationConfigDto.setPropertySpec(propertySpecDto);

        ConcatenationSpecDto concatenationSpecDto = new ConcatenationSpecDto();
        concatenationSpecDto.setConcatenationScheme(ConcatenationSpecDto.ConcatenationSchemeEnum.ZERO);

        wordificationConfigDto.setConcatenationSpec(concatenationSpecDto);

        CompositeColumnsSpecDto compositeColumnsSpecDto = new CompositeColumnsSpecDto();

        CompositeColumnsSpecEntryDto compositeColumnsSpecEntryDto = new CompositeColumnsSpecEntryDto();
        compositeColumnsSpecEntryDto.setTable1("PatientsEntity");
        compositeColumnsSpecEntryDto.setTable2("AdmissionsEntity");
        compositeColumnsSpecEntryDto.setProperty1("dob");
        compositeColumnsSpecEntryDto.setProperty2("admitTime");
        compositeColumnsSpecEntryDto.setCompositeName("ageAtAdmission");
        compositeColumnsSpecEntryDto.setCombiner(CompositeColumnsSpecEntryDto.CombinerEnum.YEAR_DIFF);

        compositeColumnsSpecDto.addEntriesItem(compositeColumnsSpecEntryDto);

        wordificationConfigDto.setCompositeColumnsSpec(compositeColumnsSpecDto);

        List<WordificationResultDto> results = propositionalizationService.computeWordification(wordificationConfigDto);

        Set<String> expectedWords = Set.of(
                "admissionsentity@insurance@private",
                "admissionsentity@language@engl",
                "admissionsentity@religion@protestant_quaker",
                "patientsentity@expireflag@0",
                "patientsentity@gender@f",
                "composite@ageatadmission@35"
        );

        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(expectedWords, new HashSet<>(results.get(0).getWords()));
    }

}
