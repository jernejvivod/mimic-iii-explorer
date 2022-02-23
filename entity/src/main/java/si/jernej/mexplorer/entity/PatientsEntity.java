package si.jernej.mexplorer.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "patients", schema = "mimiciii", catalog = "mimic")
public class PatientsEntity
{
    private int rowId;
    private int subjectId;
    private String gender;
    private LocalDateTime dob;
    private LocalDateTime dod;
    private LocalDateTime dodHosp;
    private LocalDateTime dodSsn;
    private int expireFlag;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PatientsEntity that = (PatientsEntity) o;
        return rowId == that.rowId &&
                subjectId == that.subjectId &&
                expireFlag == that.expireFlag &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(dob, that.dob) &&
                Objects.equals(dod, that.dod) &&
                Objects.equals(dodHosp, that.dodHosp) &&
                Objects.equals(dodSsn, that.dodSsn);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, gender, dob, dod, dodHosp, dodSsn, expireFlag);
    }
}
