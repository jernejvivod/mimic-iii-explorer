package si.jernej.mexplorer.core.processing;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.jernej.mexplorer.processorapi.v1.model.ExtractedTargetDto;

/**
 * Class containing target value extraction functionality.
 */
@Stateless
public class TargetExtraction
{
    private static final Logger logger = LoggerFactory.getLogger(TargetExtraction.class);

    @PersistenceContext
    private EntityManager em;

    /**
     * @param ids ids for root entity (AdmissionsEntity) for which to extract the target values
     * @return root entity (AdmissionsEntity) id and extracted target value
     */
    public List<ExtractedTargetDto> extractPatientDiedDuringAdmissionTarget(List<Long> ids)
    {
        logger.info("extracting target 'patient died during admission' ({} ids)", ids.size());

        String sql = "SELECT a.hadmId, a.hospitalExpireFlag FROM AdmissionsEntity a WHERE a.hadmId IN (:ids)";
        List<Object[]> results = em.createQuery(sql, Object[].class).setParameter("ids", ids).getResultList();

        return results.stream().map(r -> {
            ExtractedTargetDto extractedTargetDto = new ExtractedTargetDto();
            extractedTargetDto.setRootEntityId((Long) r[0]);
            extractedTargetDto.setTargetValue(((Short) r[1]).intValue());
            return extractedTargetDto;
        }).toList();
    }
}
