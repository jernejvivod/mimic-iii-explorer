package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "labevents", schema = "mimiciii", catalog = "mimic")
public class LabeventsEntity
{
    private int rowId;
    private int subjectId;
    private Integer hadmId;
    private int itemid;
    private Timestamp charttime;
    private String value;
    private Double valuenum;
    private String valueuom;
    private String flag;

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
    @Column(name = "value", nullable = true, length = 200)
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
    @Column(name = "valueuom", nullable = true, length = 20)
    public String getValueuom()
    {
        return valueuom;
    }

    public void setValueuom(String valueuom)
    {
        this.valueuom = valueuom;
    }

    @Basic
    @Column(name = "flag", nullable = true, length = 20)
    public String getFlag()
    {
        return flag;
    }

    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LabeventsEntity that = (LabeventsEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && itemid == that.itemid && Objects.equals(hadmId, that.hadmId) && Objects.equals(charttime, that.charttime) && Objects.equals(value, that.value) && Objects.equals(valuenum, that.valuenum) && Objects.equals(valueuom, that.valueuom) && Objects.equals(flag, that.flag);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, itemid, charttime, value, valuenum, valueuom, flag);
    }
}
