package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admissions", schema = "mimiciii", catalog = "mimic")
public class AdmissionsEntity
{
    private int rowId;
    private int subjectId;
    private int hadmId;
    private Timestamp admittime;
    private Timestamp dischtime;
    private Timestamp deathtime;
    private String admissionType;
    private String admissionLocation;
    private String dischargeLocation;
    private String insurance;
    private String language;
    private String religion;
    private String maritalStatus;
    private String ethnicity;
    private Timestamp edregtime;
    private Timestamp edouttime;
    private String diagnosis;
    private Short hospitalExpireFlag;
    private short hasCharteventsData;

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

    @Column(name = "subject_id", nullable = false)
    public int getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(int subjectId)
    {
        this.subjectId = subjectId;
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
    public Timestamp getAdmittime()
    {
        return admittime;
    }

    public void setAdmittime(Timestamp admittime)
    {
        this.admittime = admittime;
    }

    @Column(name = "dischtime", nullable = false)
    public Timestamp getDischtime()
    {
        return dischtime;
    }

    public void setDischtime(Timestamp dischtime)
    {
        this.dischtime = dischtime;
    }

    @Column(name = "deathtime", nullable = true)
    public Timestamp getDeathtime()
    {
        return deathtime;
    }

    public void setDeathtime(Timestamp deathtime)
    {
        this.deathtime = deathtime;
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
    public Timestamp getEdregtime()
    {
        return edregtime;
    }

    public void setEdregtime(Timestamp edregtime)
    {
        this.edregtime = edregtime;
    }

    @Column(name = "edouttime", nullable = true)
    public Timestamp getEdouttime()
    {
        return edouttime;
    }

    public void setEdouttime(Timestamp edouttime)
    {
        this.edouttime = edouttime;
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
    public short getHasCharteventsData()
    {
        return hasCharteventsData;
    }

    public void setHasCharteventsData(short hasCharteventsData)
    {
        this.hasCharteventsData = hasCharteventsData;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AdmissionsEntity that = (AdmissionsEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && hadmId == that.hadmId && hasCharteventsData == that.hasCharteventsData && Objects.equals(admittime, that.admittime) && Objects.equals(dischtime, that.dischtime) && Objects.equals(deathtime, that.deathtime) && Objects.equals(admissionType, that.admissionType) && Objects.equals(admissionLocation, that.admissionLocation) && Objects.equals(dischargeLocation, that.dischargeLocation) && Objects.equals(insurance, that.insurance) && Objects.equals(language, that.language) && Objects.equals(religion, that.religion) && Objects.equals(maritalStatus, that.maritalStatus) && Objects.equals(ethnicity, that.ethnicity)
                && Objects.equals(edregtime, that.edregtime) && Objects.equals(edouttime, that.edouttime) && Objects.equals(diagnosis, that.diagnosis) && Objects.equals(hospitalExpireFlag, that.hospitalExpireFlag);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, admittime, dischtime, deathtime, admissionType, admissionLocation, dischargeLocation, insurance, language, religion, maritalStatus, ethnicity, edregtime, edouttime, diagnosis, hospitalExpireFlag, hasCharteventsData);
    }
}
