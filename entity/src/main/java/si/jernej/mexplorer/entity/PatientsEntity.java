package si.jernej.mexplorer.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patients", schema = "mimiciii", catalog = "mimic")
public class PatientsEntity implements Serializable
{
    private int rowId;                                // row ID (primary key)
    private int subjectId;                            // patient's ID
    private String gender;                            // patient's gender
    private LocalDateTime dob;                        // Date of birth
    private LocalDateTime dod;                        // Date of death (null if the patient was alive at least 90 days post hospital discharge)
    private LocalDateTime dodHosp;                    // Date of death recorded in the hospital records
    private LocalDateTime dodSsn;                     // Date of death recorded in the social security records
    private int expireFlag;                           // Flag indicating that the patient has died
    private Set<AdmissionsEntity> admissionsEntitys;
    private Set<IcuStaysEntity> icuStaysEntitys;

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

    @Column(name = "gender", nullable = false, length = 5)
    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    @Column(name = "dob", nullable = false)
    public LocalDateTime getDob()
    {
        return dob;
    }

    public void setDob(LocalDateTime dob)
    {
        this.dob = dob;
    }

    @Column(name = "dod")
    public LocalDateTime getDod()
    {
        return dod;
    }

    public void setDod(LocalDateTime dod)
    {
        this.dod = dod;
    }

    @Column(name = "dod_hosp")
    public LocalDateTime getDodHosp()
    {
        return dodHosp;
    }

    public void setDodHosp(LocalDateTime dodHosp)
    {
        this.dodHosp = dodHosp;
    }

    @Column(name = "dod_ssn")
    public LocalDateTime getDodSsn()
    {
        return dodSsn;
    }

    public void setDodSsn(LocalDateTime dodSsn)
    {
        this.dodSsn = dodSsn;
    }

    @Column(name = "expire_flag", nullable = false)
    public int getExpireFlag()
    {
        return expireFlag;
    }

    public void setExpireFlag(int expireFlag)
    {
        this.expireFlag = expireFlag;
    }

    @OneToMany(targetEntity = AdmissionsEntity.class, mappedBy = "patientsEntity", fetch = FetchType.LAZY)
    public Set<AdmissionsEntity> getAdmissionsEntitys()
    {
        return admissionsEntitys;
    }

    public void setAdmissionsEntitys(Set<AdmissionsEntity> admissionsEntitys)
    {
        this.admissionsEntitys = admissionsEntitys;
    }

    @OneToMany(targetEntity = IcuStaysEntity.class, mappedBy = "patientsEntity", fetch = FetchType.LAZY)
    public Set<IcuStaysEntity> getIcuStaysEntitys()
    {
        return icuStaysEntitys;
    }

    public void setIcuStaysEntitys(Set<IcuStaysEntity> icuStaysEntitys)
    {
        this.icuStaysEntitys = icuStaysEntitys;
    }
}
