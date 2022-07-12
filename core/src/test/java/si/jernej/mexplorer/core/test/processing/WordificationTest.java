package si.jernej.mexplorer.core.test.processing;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import si.jernej.mexplorer.core.processing.IdRetrieval;
import si.jernej.mexplorer.core.processing.Wordification;
import si.jernej.mexplorer.core.processing.spec.PropertySpec;
import si.jernej.mexplorer.core.processing.transform.CompositeColumnCreator;
import si.jernej.mexplorer.core.processing.transform.ValueTransformer;
import si.jernej.mexplorer.core.service.TargetExtractionService;
import si.jernej.mexplorer.entity.AdmissionsEntity;
import si.jernej.mexplorer.entity.PatientsEntity;
import si.jernej.mexplorer.test.ATestBase;

class WordificationTest extends ATestBase
{
    @Override
    protected Weld loadWeld(Weld weld)
    {
        return weld.addPackages(
                true,
                getClass(),
                Wordification.class,
                TargetExtractionService.class
        );
    }

    @Inject
    private Wordification wordification;

    private static AdmissionsEntity rootAdmissionsEntity;

    @BeforeAll
    static void constructEntities()
    {
        rootAdmissionsEntity = new AdmissionsEntity();
        rootAdmissionsEntity.setAdmissionType("admissionTypeString");
        rootAdmissionsEntity.setInsurance("insuranceString");

        PatientsEntity patientsEntity = new PatientsEntity();
        patientsEntity.setGender("genderString");

        int year = 2022;
        int month = 4;
        int dayOfMonth = 18;
        int hour = 8;
        int minute = 0;
        patientsEntity.setDod(LocalDateTime.of(year, month, dayOfMonth, hour, minute));
        rootAdmissionsEntity.setPatientsEntity(patientsEntity);
    }

    @Test
    void blank()
    {
        PropertySpec propertySpec = new PropertySpec();
        ValueTransformer valueTransformer = new ValueTransformer();
        CompositeColumnCreator compositeColumnCreator = new CompositeColumnCreator();

        List<String> words = wordification.wordify(rootAdmissionsEntity, propertySpec, valueTransformer, compositeColumnCreator, Wordification.ConcatenationScheme.ZERO);

        Assertions.assertTrue(words.isEmpty());
    }

    @Test
    void basic()
    {
        Set<String> expectedWords = Set.of(
                "admissionsentity_admissiontype_admissiontypestring",
                "admissionsentity_insurance_insurancestring",
                "patientsentity_dod_2022-04-18t08:00",
                "patientsentity_gender_genderstring"
        );

        PropertySpec propertySpec = new PropertySpec();
        propertySpec.addEntry("AdmissionsEntity", List.of("admissionType", "insurance"));
        propertySpec.addEntry("PatientsEntity", List.of("gender", "dod"));

        ValueTransformer valueTransformer = new ValueTransformer();
        CompositeColumnCreator compositeColumnCreator = new CompositeColumnCreator();

        List<String> words = wordification.wordify(rootAdmissionsEntity, propertySpec, valueTransformer, compositeColumnCreator, Wordification.ConcatenationScheme.ZERO);

        Assertions.assertEquals(expectedWords, new HashSet<>(words));
    }

    @Test
    void basicOneConcatenation()
    {
        Set<String> expectedWords = Set.of(
                "admissionsentity_admissiontype_admissiontypestring",
                "admissionsentity_insurance_insurancestring",
                "admissionsentity_admissiontype_admissiontypestring__admissionsentity_insurance_insurancestring",
                "patientsentity_dod_2022-04-18t08:00",
                "patientsentity_gender_genderstring",
                "patientsentity_dod_2022-04-18t08:00__patientsentity_gender_genderstring"
        );

        PropertySpec propertySpec = new PropertySpec();
        propertySpec.addEntry("AdmissionsEntity", List.of("admissionType", "insurance"));
        propertySpec.addEntry("PatientsEntity", List.of("gender", "dod"));

        ValueTransformer valueTransformer = new ValueTransformer();
        CompositeColumnCreator compositeColumnCreator = new CompositeColumnCreator();

        List<String> words = wordification.wordify(rootAdmissionsEntity, propertySpec, valueTransformer, compositeColumnCreator, Wordification.ConcatenationScheme.ONE);

        Assertions.assertEquals(expectedWords, new HashSet<>(words));
    }

    @Test
    void basicTwoConcatenation()
    {
        Set<String> expectedWords = Set.of(
                "admissionsentity_admissiontype_admissiontypestring",
                "admissionsentity_insurance_insurancestring",
                "admissionsentity_admissiontype_admissiontypestring__admissionsentity_insurance_insurancestring",
                "patientsentity_dod_2022-04-18t08:00",
                "patientsentity_gender_genderstring",
                "patientsentity_dod_2022-04-18t08:00__patientsentity_gender_genderstring"
        );

        PropertySpec propertySpec = new PropertySpec();
        propertySpec.addEntry("AdmissionsEntity", List.of("admissionType", "insurance"));
        propertySpec.addEntry("PatientsEntity", List.of("gender", "dod"));

        ValueTransformer valueTransformer = new ValueTransformer();
        CompositeColumnCreator compositeColumnCreator = new CompositeColumnCreator();

        List<String> words = wordification.wordify(rootAdmissionsEntity, propertySpec, valueTransformer, compositeColumnCreator, Wordification.ConcatenationScheme.TWO);

        Assertions.assertEquals(expectedWords, new HashSet<>(words));
    }

    // TODO tests for composite column creation, value transformation and both (combined)

}
