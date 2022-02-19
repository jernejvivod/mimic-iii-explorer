package si.jernej.mexplorer.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "icustays", schema = "mimiciii", catalog = "mimic")
public class IcuStaysEntity implements Serializable
{
    private int rowId;                          // row ID (primary key)
    private PatientsEntity patientsEntity;
    private AdmissionsEntity admissionsEntity;
    private int icuStayId;                      // ICU stay ID
    private String dbSource;                    // source database of the item
    private String firstCareUnit;               // first care unit associated with the ICU stay
    private String lastCareUnit;                // last care unit associated with the ICU stay
    private short firstWardId;                  // identifier for the first ward the patient was located in
    private short lastWardId;                   // identifier for the last ward the patient is located in
    private Timestamp inTime;                   // time of admission to the ICU
    private Timestamp outTime;                  // time of discharge from the ICU
    private Double los;                         // length of stay in the ICU in fractional days

    @Id
    @Column(name = "row_id", nullable = false)
    public int getRowId()
    {
        return rowId;
    }

    public void setRowId(int rowId)
    {
        this.rowId = rowId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    public PatientsEntity getPatientsEntity()
    {
        return patientsEntity;
    }

    public void setPatientsEntity(PatientsEntity patientsEntity)
    {
        this.patientsEntity = patientsEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hadm_id", referencedColumnName = "hadm_id")
    public AdmissionsEntity getAdmissionsEntity()
    {
        return admissionsEntity;
    }

    public void setAdmissionsEntity(AdmissionsEntity admissionsEntity)
    {
        this.admissionsEntity = admissionsEntity;
    }

    @Column(name = "icustay_id", nullable = false)
    public int getIcuStayId()
    {
        return icuStayId;
    }

    public void setIcuStayId(int icustayId)
    {
        this.icuStayId = icustayId;
    }

    @Column(name = "dbsource", nullable = false, length = 20)
    public String getDbSource()
    {
        return dbSource;
    }

    public void setDbSource(String dbsource)
    {
        this.dbSource = dbsource;
    }

    @Column(name = "first_careunit", nullable = false, length = 20)
    public String getFirstCareUnit()
    {
        return firstCareUnit;
    }

    public void setFirstCareUnit(String firstCareunit)
    {
        this.firstCareUnit = firstCareunit;
    }

    @Column(name = "last_careunit", nullable = false, length = 20)
    public String getLastCareUnit()
    {
        return lastCareUnit;
    }

    public void setLastCareUnit(String lastCareunit)
    {
        this.lastCareUnit = lastCareunit;
    }

    @Column(name = "first_wardid", nullable = false)
    public short getFirstWardId()
    {
        return firstWardId;
    }

    public void setFirstWardId(short firstWardid)
    {
        this.firstWardId = firstWardid;
    }

    @Column(name = "last_wardid", nullable = false)
    public short getLastWardId()
    {
        return lastWardId;
    }

    public void setLastWardId(short lastWardid)
    {
        this.lastWardId = lastWardid;
    }

    @Column(name = "intime", nullable = false)
    public Timestamp getInTime()
    {
        return inTime;
    }

    public void setInTime(Timestamp intime)
    {
        this.inTime = intime;
    }

    @Column(name = "outtime", nullable = true)
    public Timestamp getOutTime()
    {
        return outTime;
    }

    public void setOutTime(Timestamp outtime)
    {
        this.outTime = outtime;
    }

    @Column(name = "los", nullable = true, precision = 0)
    public Double getLos()
    {
        return los;
    }

    public void setLos(Double los)
    {
        this.los = los;
    }

}
