package si.jernej.mexplorer.core.test.processing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import si.jernej.mexplorer.core.manager.MimicEntityManager;
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
                TargetExtractionService.class,
                MimicEntityManager.class
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
        rootAdmissionsEntity.setAdmitTime(LocalDateTime.of(LocalDate.of(2012, 2, 13), LocalTime.of(8, 13)));

        PatientsEntity patientsEntity = new PatientsEntity();
        patientsEntity.setGender("genderString");
        patientsEntity.setDob(LocalDateTime.of(LocalDate.of(1955, 8, 3), LocalTime.of(0, 0)));

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
                "admissionsentity@admissiontype@admissiontypestring",
                "admissionsentity@insurance@insurancestring",
                "patientsentity@dod@2022-04-18t08:00",
                "patientsentity@gender@genderstring"
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
                "admissionsentity@admissiontype@admissiontypestring",
                "admissionsentity@insurance@insurancestring",
                "admissionsentity@admissiontype@admissiontypestring@@admissionsentity@insurance@insurancestring",
                "patientsentity@dod@2022-04-18t08:00",
                "patientsentity@gender@genderstring",
                "patientsentity@dod@2022-04-18t08:00@@patientsentity@gender@genderstring"
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
                "admissionsentity@admissiontype@admissiontypestring",
                "admissionsentity@insurance@insurancestring",
                "admissionsentity@admissiontype@admissiontypestring@@admissionsentity@insurance@insurancestring",
                "patientsentity@dod@2022-04-18t08:00",
                "patientsentity@gender@genderstring",
                "patientsentity@dod@2022-04-18t08:00@@patientsentity@gender@genderstring"
        );

        PropertySpec propertySpec = new PropertySpec();
        propertySpec.addEntry("AdmissionsEntity", List.of("admissionType", "insurance"));
        propertySpec.addEntry("PatientsEntity", List.of("gender", "dod"));

        ValueTransformer valueTransformer = new ValueTransformer();
        CompositeColumnCreator compositeColumnCreator = new CompositeColumnCreator();

        List<String> words = wordification.wordify(rootAdmissionsEntity, propertySpec, valueTransformer, compositeColumnCreator, Wordification.ConcatenationScheme.TWO);

        Assertions.assertEquals(expectedWords, new HashSet<>(words));
    }

    @Test
    void basicWithCompositeColumnCreator()
    {
        Set<String> expectedWords = Set.of(
                "admissionsentity@admissiontype@admissiontypestring",
                "admissionsentity@insurance@insurancestring",
                "admissionsentity@admissiontype@admissiontypestring@@admissionsentity@insurance@insurancestring",
                "patientsentity@dod@2022-04-18t08:00",
                "patientsentity@gender@genderstring",
                "patientsentity@dod@2022-04-18t08:00@@patientsentity@gender@genderstring",
                "composite@ageatadmission@56"
        );

        PropertySpec propertySpec = new PropertySpec();
        propertySpec.addEntry("AdmissionsEntity", List.of("admissionType", "insurance"));
        propertySpec.addEntry("PatientsEntity", List.of("gender", "dod"));

        ValueTransformer valueTransformer = new ValueTransformer();
        CompositeColumnCreator compositeColumnCreator = new CompositeColumnCreator();
        compositeColumnCreator.addEntry(
                List.of("AdmissionsEntity"),
                "admitTime",
                List.of("AdmissionsEntity", "PatientsEntity"),
                "dob",
                "ageAtAdmission",
                (dateAdmission, dateBirth) -> ChronoUnit.YEARS.between((LocalDateTime) dateBirth, (LocalDateTime) dateAdmission)
        );

        List<String> words = wordification.wordify(rootAdmissionsEntity, propertySpec, valueTransformer, compositeColumnCreator, Wordification.ConcatenationScheme.TWO);

        Assertions.assertEquals(expectedWords, new HashSet<>(words));
    }

    @Test
    void basicWithValueTransformer()
    {

    }

    @Test
    void basicWithCompositeColumnCreatorAndValueTransformer()
    {
        Set<String> expectedWords = Set.of(
                "admissionsentity@admissiontype@admissiontypestring",
                "admissionsentity@insurance@insurancestring",
                "admissionsentity@admissiontype@admissiontypestring@@admissionsentity@insurance@insurancestring",
                "patientsentity@dod@2022-04-18t08:00",
                "patientsentity@gender@genderstring",
                "patientsentity@dod@2022-04-18t08:00@@patientsentity@gender@genderstring",
                "composite@ageatadmission@60"
        );

        PropertySpec propertySpec = new PropertySpec();
        propertySpec.addEntry("AdmissionsEntity", List.of("admissionType", "insurance"));
        propertySpec.addEntry("PatientsEntity", List.of("gender", "dod"));

        ValueTransformer valueTransformer = new ValueTransformer();
        valueTransformer.addTransform(
                "composite",
                "ageAtAdmission",
                x -> String.valueOf((long) (20.0 * Math.round(((long) x) / 20.0)))
        );

        CompositeColumnCreator compositeColumnCreator = new CompositeColumnCreator();
        compositeColumnCreator.addEntry(
                List.of("AdmissionsEntity"),
                "admitTime",
                List.of("AdmissionsEntity", "PatientsEntity"),
                "dob",
                "ageAtAdmission",
                (dateAdmission, dateBirth) -> ChronoUnit.YEARS.between((LocalDateTime) dateBirth, (LocalDateTime) dateAdmission)
        );

        List<String> words = wordification.wordify(rootAdmissionsEntity, propertySpec, valueTransformer, compositeColumnCreator, Wordification.ConcatenationScheme.TWO);

        Assertions.assertEquals(expectedWords, new HashSet<>(words));
    }

}
