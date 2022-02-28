package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chartevents", schema = "mimiciii", catalog = "mimic")
public class CharteventsEntity
{
    private int rowId;
    private int subjectId;
    private Integer hadmId;
    private Integer icustayId;
    private Integer itemid;
    private Timestamp charttime;
    private Timestamp storetime;
    private Integer cgid;
    private String value;
    private Double valuenum;
    private String valueuom;
    private Integer warning;
    private Integer error;
    private String resultstatus;
    private String stopped;

    @Basic
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
    @Column(name = "itemid", nullable = true)
    public Integer getItemid()
    {
        return itemid;
    }

    public void setItemid(Integer itemid)
    {
        this.itemid = itemid;
    }

    @Basic
    @Column(name = "charttime", nullable = true)
    public Timestamp getCharttime()
    {
        return charttime;
    }

    public void setCharttime(Timestamp charttime)
    {
        this.charttime = charttime;
    }

    @Basic
    @Column(name = "storetime", nullable = true)
    public Timestamp getStoretime()
    {
        return storetime;
    }

    public void setStoretime(Timestamp storetime)
    {
        this.storetime = storetime;
    }

    @Basic
    @Column(name = "cgid", nullable = true)
    public Integer getCgid()
    {
        return cgid;
    }

    public void setCgid(Integer cgid)
    {
        this.cgid = cgid;
    }

    @Basic
    @Column(name = "value", nullable = true, length = 255)
    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @Basic
    @Column(name = "valuenum", nullable = true, precision = 0)
    public Double getValuenum()
    {
        return valuenum;
    }

    public void setValuenum(Double valuenum)
    {
        this.valuenum = valuenum;
    }

    @Basic
    @Column(name = "valueuom", nullable = true, length = 50)
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
    public Integer getWarning()
    {
        return warning;
    }

    public void setWarning(Integer warning)
    {
        this.warning = warning;
    }

    @Basic
    @Column(name = "error", nullable = true)
    public Integer getError()
    {
        return error;
    }

    public void setError(Integer error)
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
        CharteventsEntity that = (CharteventsEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && Objects.equals(hadmId, that.hadmId) && Objects.equals(icustayId, that.icustayId) && Objects.equals(itemid, that.itemid) && Objects.equals(charttime, that.charttime) && Objects.equals(storetime, that.storetime) && Objects.equals(cgid, that.cgid) && Objects.equals(value, that.value) && Objects.equals(valuenum, that.valuenum) && Objects.equals(valueuom, that.valueuom) && Objects.equals(warning, that.warning) && Objects.equals(error, that.error) && Objects.equals(resultstatus, that.resultstatus) && Objects.equals(stopped, that.stopped);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, icustayId, itemid, charttime, storetime, cgid, value, valuenum, valueuom, warning, error, resultstatus, stopped);
    }
}
