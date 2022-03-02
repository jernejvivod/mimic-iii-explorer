package si.jernej.mexplorer.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admissions", schema = "mimiciii", catalog = "mimic")
public class AdmissionsEntity implements Serializable
{
    private int rowId;                  // row ID (primary key)
    PatientsEntity patientsEntity;
    private int hadmId;                 // hospital admission ID
    private LocalDateTime admitTime;    // time of admission to the hospital
    private LocalDateTime dischTime;    // time of discharge from the hospital
    private LocalDateTime deathTime;    // time of death
    private String admissionType;       // type of admission (for example emergency or elective)
    private String admissionLocation;   // admission location
    private String dischargeLocation;   // discharge location
    private String insurance;           // insurance type
    private String language;            // language
    private String religion;            // religion
    private String maritalStatus;       // marital status
    private String ethnicity;           // ethnicity
    private LocalDateTime edRegTime;    // ?
    private LocalDateTime edOutTime;    // ?
    private String diagnosis;           // diagnosis
    private Short hospitalExpireFlag;   // ?
    private short hasChartEventsData;   // hospital admission ahs at least one observation in the chartevents table

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

    @Column(name = "hadm_id", nullable = false)
    public int getHadmId()
    {
        return hadmId;
    }

    public void setHadmId(int hadmId)
    {
        this.hadmId = hadmId;
    }

    @Column(name = "admittime", nullable = false)
    public LocalDateTime getAdmitTime()
    {
        return admitTime;
    }

    public void setAdmitTime(LocalDateTime admittime)
    {
        this.admitTime = admittime;
    }

    @Column(name = "dischtime", nullable = false)
    public LocalDateTime getDischTime()
    {
        return dischTime;
    }

    public void setDischTime(LocalDateTime dischtime)
    {
        this.dischTime = dischtime;
    }

    @Column(name = "deathtime", nullable = true)
    public LocalDateTime getDeathTime()
    {
        return deathTime;
    }

    public void setDeathTime(LocalDateTime deathtime)
    {
        this.deathTime = deathtime;
    }

    @Column(name = "admission_type", nullable = false, length = 50)
    public String getAdmissionType()
    {
        return admissionType;
    }

    public void setAdmissionType(String admissionType)
    {
        this.admissionType = admissionType;
    }

    @Column(name = "admission_location", nullable = false, length = 50)
    public String getAdmissionLocation()
    {
        return admissionLocation;
    }

    public void setAdmissionLocation(String admissionLocation)
    {
        this.admissionLocation = admissionLocation;
    }

    @Column(name = "discharge_location", nullable = false, length = 50)
    public String getDischargeLocation()
    {
        return dischargeLocation;
    }

    public void setDischargeLocation(String dischargeLocation)
    {
        this.dischargeLocation = dischargeLocation;
    }

    @Column(name = "insurance", nullable = false, length = 255)
    public String getInsurance()
    {
        return insurance;
    }

    public void setInsurance(String insurance)
    {
        this.insurance = insurance;
    }

    @Column(name = "language", nullable = true, length = 10)
    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    @Column(name = "religion", nullable = true, length = 50)
    public String getReligion()
    {
        return religion;
    }

    public void setReligion(String religion)
    {
        this.religion = religion;
    }

    @Column(name = "marital_status", nullable = true, length = 50)
    public String getMaritalStatus()
    {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }

    @Column(name = "ethnicity", nullable = false, length = 200)
    public String getEthnicity()
    {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity)
    {
        this.ethnicity = ethnicity;
    }

    @Column(name = "edregtime", nullable = true)
    public LocalDateTime getEdRegTime()
    {
        return edRegTime;
    }

    public void setEdRegTime(LocalDateTime edregtime)
    {
        this.edRegTime = edregtime;
    }

    @Column(name = "edouttime", nullable = true)
    public LocalDateTime getEdOutTime()
    {
        return edOutTime;
    }

    public void setEdOutTime(LocalDateTime edouttime)
    {
        this.edOutTime = edouttime;
    }

    @Column(name = "diagnosis", nullable = true, length = 255)
    public String getDiagnosis()
    {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    @Column(name = "hospital_expire_flag", nullable = true)
    public Short getHospitalExpireFlag()
    {
        return hospitalExpireFlag;
    }

    public void setHospitalExpireFlag(Short hospitalExpireFlag)
    {
        this.hospitalExpireFlag = hospitalExpireFlag;
    }

    @Column(name = "has_chartevents_data", nullable = false)
    public short getHasChartEventsData()
    {
        return hasChartEventsData;
    }

    public void setHasChartEventsData(short hasCharteventsData)
    {
        this.hasChartEventsData = hasCharteventsData;
    }

}
