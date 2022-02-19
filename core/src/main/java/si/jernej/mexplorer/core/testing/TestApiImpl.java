package si.jernej.mexplorer.core.testing;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

import si.jernej.mexplorer.core.api.v1.endpoint.TestApi;
import si.jernej.mexplorer.core.manager.PatientsManager;
import si.jernej.mexplorer.core.processing.Wordification;

@Stateless
public class TestApiImpl implements TestApi
{

    @Inject
    PatientsManager patientsManager;
    @Inject
    Wordification wordification;

    /**
     * Method for testing implemented functionality.
     */
    @Override
    public Response test(String id)
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
                Map.entry("PatientsEntity", Set.of(
                        "gender",
                        "dob",
                        "dod"
                )),
                Map.entry("IcuStayEntity", Set.of(
                        "",
                        "",
                        ""
                ))
        );

        TypedQuery<Integer> query = patientsManager.getEntityManager().createQuery("SELECT e.hadmId from AdmissionsEntity e", Integer.class);
        List<Integer> resultList = query.getResultList();

        List<String> wordify = wordification.wordify("AdmissionsEntity", "hadmId", resultList.get(0).toString(), tableNameToValueFields, null, Wordification.ConcatenationScheme.ONE);

        return Response.noContent().build();
    }
}
