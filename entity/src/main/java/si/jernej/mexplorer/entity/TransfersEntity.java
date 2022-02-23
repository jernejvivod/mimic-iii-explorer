package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transfers", schema = "mimiciii", catalog = "mimic")
public class TransfersEntity
{
    private int rowId;
    private int subjectId;
    private int hadmId;
    private Integer icustayId;
    private String dbsource;
    private String eventtype;
    private String prevCareunit;
    private String currCareunit;
    private Short prevWardid;
    private Short currWardid;
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
    @Column(name = "icustay_id", nullable = true)
    public Integer getIcustayId()
    {
        return icustayId;
    }

    public void setIcustayId(Integer icustayId)
    {
        this.icustayId = icustayId;
    }

    @Basic
    @Column(name = "dbsource", nullable = true, length = 20)
    public String getDbsource()
    {
        return dbsource;
    }

    public void setDbsource(String dbsource)
    {
        this.dbsource = dbsource;
    }

    @Basic
    @Column(name = "eventtype", nullable = true, length = 20)
    public String getEventtype()
    {
        return eventtype;
    }

    public void setEventtype(String eventtype)
    {
        this.eventtype = eventtype;
    }

    @Basic
    @Column(name = "prev_careunit", nullable = true, length = 20)
    public String getPrevCareunit()
    {
        return prevCareunit;
    }

    public void setPrevCareunit(String prevCareunit)
    {
        this.prevCareunit = prevCareunit;
    }

    @Basic
    @Column(name = "curr_careunit", nullable = true, length = 20)
    public String getCurrCareunit()
    {
        return currCareunit;
    }

    public void setCurrCareunit(String currCareunit)
    {
        this.currCareunit = currCareunit;
    }

    @Basic
    @Column(name = "prev_wardid", nullable = true)
    public Short getPrevWardid()
    {
        return prevWardid;
    }

    public void setPrevWardid(Short prevWardid)
    {
        this.prevWardid = prevWardid;
    }

    @Basic
    @Column(name = "curr_wardid", nullable = true)
    public Short getCurrWardid()
    {
        return currWardid;
    }

    public void setCurrWardid(Short currWardid)
    {
        this.currWardid = currWardid;
    }

    @Basic
    @Column(name = "intime", nullable = true)
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
        TransfersEntity that = (TransfersEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && hadmId == that.hadmId && Objects.equals(icustayId, that.icustayId) && Objects.equals(dbsource, that.dbsource) && Objects.equals(eventtype, that.eventtype) && Objects.equals(prevCareunit, that.prevCareunit) && Objects.equals(currCareunit, that.currCareunit) && Objects.equals(prevWardid, that.prevWardid) && Objects.equals(currWardid, that.currWardid) && Objects.equals(intime, that.intime) && Objects.equals(outtime, that.outtime) && Objects.equals(los, that.los);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, icustayId, dbsource, eventtype, prevCareunit, currCareunit, prevWardid, currWardid, intime, outtime, los);
    }
}
