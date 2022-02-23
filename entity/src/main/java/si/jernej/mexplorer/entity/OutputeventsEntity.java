package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "outputevents", schema = "mimiciii", catalog = "mimic")
public class OutputeventsEntity
{
    private int rowId;
    private int subjectId;
    private Integer hadmId;
    private Integer icustayId;
    private Timestamp charttime;
    private Integer itemid;
    private Double value;
    private String valueuom;
    private Timestamp storetime;
    private Integer cgid;
    private String stopped;
    private String newbottle;
    private Integer iserror;

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
    @Column(name = "value", nullable = true, precision = 0)
    public Double getValue()
    {
        return value;
    }

    public void setValue(Double value)
    {
        this.value = value;
    }

    @Basic
    @Column(name = "valueuom", nullable = true, length = 30)
    public String getValueuom()
    {
        return valueuom;
    }

    public void setValueuom(String valueuom)
    {
        this.valueuom = valueuom;
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
    @Column(name = "stopped", nullable = true, length = 30)
    public String getStopped()
    {
        return stopped;
    }

    public void setStopped(String stopped)
    {
        this.stopped = stopped;
    }

    @Basic
    @Column(name = "newbottle", nullable = true, length = -1)
    public String getNewbottle()
    {
        return newbottle;
    }

    public void setNewbottle(String newbottle)
    {
        this.newbottle = newbottle;
    }

    @Basic
    @Column(name = "iserror", nullable = true)
    public Integer getIserror()
    {
        return iserror;
    }

    public void setIserror(Integer iserror)
    {
        this.iserror = iserror;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OutputeventsEntity that = (OutputeventsEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && Objects.equals(hadmId, that.hadmId) && Objects.equals(icustayId, that.icustayId) && Objects.equals(charttime, that.charttime) && Objects.equals(itemid, that.itemid) && Objects.equals(value, that.value) && Objects.equals(valueuom, that.valueuom) && Objects.equals(storetime, that.storetime) && Objects.equals(cgid, that.cgid) && Objects.equals(stopped, that.stopped) && Objects.equals(newbottle, that.newbottle) && Objects.equals(iserror, that.iserror);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, icustayId, charttime, itemid, value, valueuom, storetime, cgid, stopped, newbottle, iserror);
    }
}
