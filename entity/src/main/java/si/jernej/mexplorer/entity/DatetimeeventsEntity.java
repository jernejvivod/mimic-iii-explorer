package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datetimeevents", schema = "mimiciii", catalog = "mimic")
public class DatetimeeventsEntity
{
    private int rowId;
    private int subjectId;
    private Integer hadmId;
    private Integer icustayId;
    private int itemid;
    private Timestamp charttime;
    private Timestamp storetime;
    private int cgid;
    private Timestamp value;
    private String valueuom;
    private Short warning;
    private Short error;
    private String resultstatus;
    private String stopped;

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
    @Column(name = "hadm_id", nullable = true)
    public Integer getHadmId()
    {
        return hadmId;
    }

    public void setHadmId(Integer hadmId)
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
    @Column(name = "itemid", nullable = false)
    public int getItemid()
    {
        return itemid;
    }

    public void setItemid(int itemid)
    {
        this.itemid = itemid;
    }

    @Basic
    @Column(name = "charttime", nullable = false)
    public Timestamp getCharttime()
    {
        return charttime;
    }

    public void setCharttime(Timestamp charttime)
    {
        this.charttime = charttime;
    }

    @Basic
    @Column(name = "storetime", nullable = false)
    public Timestamp getStoretime()
    {
        return storetime;
    }

    public void setStoretime(Timestamp storetime)
    {
        this.storetime = storetime;
    }

    @Basic
    @Column(name = "cgid", nullable = false)
    public int getCgid()
    {
        return cgid;
    }

    public void setCgid(int cgid)
    {
        this.cgid = cgid;
    }

    @Basic
    @Column(name = "value", nullable = true)
    public Timestamp getValue()
    {
        return value;
    }

    public void setValue(Timestamp value)
    {
        this.value = value;
    }

    @Basic
    @Column(name = "valueuom", nullable = false, length = 50)
    public String getValueuom()
    {
        return valueuom;
    }

    public void setValueuom(String valueuom)
    {
        this.valueuom = valueuom;
    }

    @Basic
    @Column(name = "warning", nullable = true)
    public Short getWarning()
    {
        return warning;
    }

    public void setWarning(Short warning)
    {
        this.warning = warning;
    }

    @Basic
    @Column(name = "error", nullable = true)
    public Short getError()
    {
        return error;
    }

    public void setError(Short error)
    {
        this.error = error;
    }

    @Basic
    @Column(name = "resultstatus", nullable = true, length = 50)
    public String getResultstatus()
    {
        return resultstatus;
    }

    public void setResultstatus(String resultstatus)
    {
        this.resultstatus = resultstatus;
    }

    @Basic
    @Column(name = "stopped", nullable = true, length = 50)
    public String getStopped()
    {
        return stopped;
    }

    public void setStopped(String stopped)
    {
        this.stopped = stopped;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DatetimeeventsEntity that = (DatetimeeventsEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && itemid == that.itemid && cgid == that.cgid && Objects.equals(hadmId, that.hadmId) && Objects.equals(icustayId, that.icustayId) && Objects.equals(charttime, that.charttime) && Objects.equals(storetime, that.storetime) && Objects.equals(value, that.value) && Objects.equals(valueuom, that.valueuom) && Objects.equals(warning, that.warning) && Objects.equals(error, that.error) && Objects.equals(resultstatus, that.resultstatus) && Objects.equals(stopped, that.stopped);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, icustayId, itemid, charttime, storetime, cgid, value, valueuom, warning, error, resultstatus, stopped);
    }
}
