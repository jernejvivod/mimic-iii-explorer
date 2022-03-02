package si.jernej.mexplorer.core.testing;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

import si.jernej.mexplorer.core.api.v1.endpoint.TestApi;
import si.jernej.mexplorer.core.manager.AdmissionsManager;
import si.jernej.mexplorer.core.manager.PatientsManager;
import si.jernej.mexplorer.core.processing.PropertySpec;
import si.jernej.mexplorer.core.processing.Wordification;
import si.jernej.mexplorer.core.transform.CompositeColumnCreator;
import si.jernej.mexplorer.core.transform.ValueTransformer;
import si.jernej.mexplorer.entity.AdmissionsEntity;

@Stateless
public class TestApiImpl implements TestApi
{

    @Inject
    PatientsManager patientsManager;
    @Inject
    AdmissionsManager admissionsManager;
    @Inject
    Wordification wordification;

    /**
     * Method for testing implemented functionality.
     */
    @Override
    public Response testWordification(String id)
    {
        Map<String, Set<String>> tableNameToValueFields = Map.ofEntries(
                Map.entry("AdmissionsEntity", Set.of("admissionType",
                        "admissionLocation",
                        "dischargeLocation",
                        "insurance",
                        "language",
                        "religion",
                        "maritalStatus",
                        "ethnicity"
                )),
                Map.entry("PatientsEntity", Set.of("gender", "dob", "dod"))
        );

        PropertySpec propertySpec = new PropertySpec();
        propertySpec.addEntry("AdmissionsEntity", Set.of("admissionType", "admissionLocation", "dischargeLocation", "insurance", "language", "religion", "maritalStatus", "ethnicity"));
        propertySpec.addEntry("PatientsEntity", Set.of("gender", "dob", "dod"));

        ValueTransformer valueTransformer = new ValueTransformer(val -> val instanceof String ? ((String) val).replace(' ', '@') : val);
        valueTransformer.addTransform("AdmissionsEntity", "insurance", e -> ((String) e).toUpperCase());

        TypedQuery<Integer> query = patientsManager.getEntityManager().createQuery("SELECT e.hadmId from AdmissionsEntity e", Integer.class);
        List<Integer> resultList = query.getResultList();

        List<String> wordify = wordification.wordify("AdmissionsEntity", "hadmId", resultList.get(0).toString(), propertySpec, valueTransformer, null, Wordification.ConcatenationScheme.ONE);

        return Response.noContent().build();
    }

    @Override
    public Response testCompositeColumnCreator(String id)
    {

        CompositeColumnCreator compositeColumnCreator = new CompositeColumnCreator();

        List<String> foreignKeyPath1 = new ArrayList<>(Collections.emptyList());
        String property1 = "admitTime";
        List<String> foreignKeyPath2 = new ArrayList<>(List.of("PatientsEntity"));
        String property2 = "dob";

        compositeColumnCreator.addEntry(foreignKeyPath1, property1, foreignKeyPath2, property2, "age", (dod, dob) -> ChronoUnit.YEARS.between((LocalDateTime) dob, (LocalDateTime) dod));

        AdmissionsEntity admissionsEntity = admissionsManager.getFirst();

        Map<String, List<Object>> res = compositeColumnCreator.processEntries(Collections.singletonList(admissionsEntity));

        return Response.noContent().build();
    }
}
