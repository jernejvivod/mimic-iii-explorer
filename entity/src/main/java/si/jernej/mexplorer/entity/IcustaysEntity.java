package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "icustays", schema = "mimiciii", catalog = "mimic")
public class IcustaysEntity
{
    private int rowId;
    private int subjectId;
    private int hadmId;
    private int icustayId;
    private String dbsource;
    private String firstCareunit;
    private String lastCareunit;
    private short firstWardid;
    private short lastWardid;
    private Timestamp intime;
    private Timestamp outtime;
    private Double los;

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

    @Basic
    @Column(name = "subject_id", nullable = false)
    public int getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(int subjectId)
    {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "hadm_id", nullable = false)
    public int getHadmId()
    {
        return hadmId;
    }

    public void setHadmId(int hadmId)
    {
        this.hadmId = hadmId;
    }

    @Basic
    @Column(name = "icustay_id", nullable = false)
    public int getIcustayId()
    {
        return icustayId;
    }

    public void setIcustayId(int icustayId)
    {
        this.icustayId = icustayId;
    }

    @Basic
    @Column(name = "dbsource", nullable = false, length = 20)
    public String getDbsource()
    {
        return dbsource;
    }

    public void setDbsource(String dbsource)
    {
        this.dbsource = dbsource;
    }

    @Basic
    @Column(name = "first_careunit", nullable = false, length = 20)
    public String getFirstCareunit()
    {
        return firstCareunit;
    }

    public void setFirstCareunit(String firstCareunit)
    {
        this.firstCareunit = firstCareunit;
    }

    @Basic
    @Column(name = "last_careunit", nullable = false, length = 20)
    public String getLastCareunit()
    {
        return lastCareunit;
    }

    public void setLastCareunit(String lastCareunit)
    {
        this.lastCareunit = lastCareunit;
    }

    @Basic
    @Column(name = "first_wardid", nullable = false)
    public short getFirstWardid()
    {
        return firstWardid;
    }

    public void setFirstWardid(short firstWardid)
    {
        this.firstWardid = firstWardid;
    }

    @Basic
    @Column(name = "last_wardid", nullable = false)
    public short getLastWardid()
    {
        return lastWardid;
    }

    public void setLastWardid(short lastWardid)
    {
        this.lastWardid = lastWardid;
    }

    @Basic
    @Column(name = "intime", nullable = false)
    public Timestamp getIntime()
    {
        return intime;
    }

    public void setIntime(Timestamp intime)
    {
        this.intime = intime;
    }

    @Basic
    @Column(name = "outtime", nullable = true)
    public Timestamp getOuttime()
    {
        return outtime;
    }

    public void setOuttime(Timestamp outtime)
    {
        this.outtime = outtime;
    }

    @Basic
    @Column(name = "los", nullable = true, precision = 0)
    public Double getLos()
    {
        return los;
    }

    public void setLos(Double los)
    {
        this.los = los;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        IcustaysEntity that = (IcustaysEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && hadmId == that.hadmId && icustayId == that.icustayId && firstWardid == that.firstWardid && lastWardid == that.lastWardid && Objects.equals(dbsource, that.dbsource) && Objects.equals(firstCareunit, that.firstCareunit) && Objects.equals(lastCareunit, that.lastCareunit) && Objects.equals(intime, that.intime) && Objects.equals(outtime, that.outtime) && Objects.equals(los, that.los);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, icustayId, dbsource, firstCareunit, lastCareunit, firstWardid, lastWardid, intime, outtime, los);
    }
}
