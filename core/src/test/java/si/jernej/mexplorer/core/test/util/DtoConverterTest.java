package si.jernej.mexplorer.core.test.util;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import si.jernej.mexplorer.core.processing.spec.PropertySpec;
import si.jernej.mexplorer.core.util.DtoConverter;
import si.jernej.mexplorer.processorapi.v1.model.PropertySpecDto;
import si.jernej.mexplorer.processorapi.v1.model.PropertySpecEntryDto;

class DtoConverterTest
{
    @Test
    void testToPropertySpecEmpty()
    {
        PropertySpecDto propertySpecDto = new PropertySpecDto();
        PropertySpec propertySpec = DtoConverter.toPropertySpec(propertySpecDto);
        Assertions.assertFalse(propertySpec.containsEntry("AdmissionsEntity", "admissionType"));
    }

    @Test
    void testToPropertySpec()
    {
        final String ENTITY1 = "AdmissionsEntity";
        final String ENTITY2 = "PatientsEntity";
        final List<String> PROPERTIES_LIST1 = List.of("admissionType", "insurance");
        final List<String> PROPERTIES_LIST2 = List.of("gender", "dod");

        PropertySpecDto propertySpecDto = new PropertySpecDto();

        PropertySpecEntryDto propertySpecEntryDto1 = new PropertySpecEntryDto();
        propertySpecEntryDto1.setEntity(ENTITY1);
        propertySpecEntryDto1.setProperties(PROPERTIES_LIST1);

        PropertySpecEntryDto propertySpecEntryDto2 = new PropertySpecEntryDto();
        propertySpecEntryDto1.setEntity(ENTITY2);
        propertySpecEntryDto1.setProperties(PROPERTIES_LIST2);

        propertySpecDto.setEntries(List.of(propertySpecEntryDto1, propertySpecEntryDto2));

        PropertySpec propertySpec = DtoConverter.toPropertySpec(propertySpecDto);

        assertToPropertySpecConversion(propertySpecDto, propertySpec);
    }

    void assertToPropertySpecConversion(PropertySpecDto propertySpecDto, PropertySpec propertySpec)
    {
        for (PropertySpecEntryDto entry : propertySpecDto.getEntries())
        {
            for (String property : entry.getProperties())
            {
                Assertions.assertTrue(propertySpec.containsEntry(entry.getEntity(), property));
                Assertions.assertFalse(propertySpec.containsEntry("DOES_NOT_EXIST", property));
                Assertions.assertFalse(propertySpec.containsEntry(entry.getEntity(), "DOES_NOT_EXIST"));
            }
        }
        Assertions.assertFalse(propertySpec.containsEntry("DOES_NOT_EXIST", "DOES_NOT_EXIST"));
    }
}
