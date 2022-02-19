package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noteevents", schema = "mimiciii", catalog = "mimic")
public class NoteeventsEntity
{
    private int rowId;
    private int subjectId;
    private Integer hadmId;
    private Timestamp chartdate;
    private Timestamp charttime;
    private Timestamp storetime;
    private String category;
    private String description;
    private Integer cgid;
    private String iserror;
    private String text;

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
    @Column(name = "chartdate", nullable = true)
    public Timestamp getChartdate()
    {
        return chartdate;
    }

    public void setChartdate(Timestamp chartdate)
    {
        this.chartdate = chartdate;
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
    @Column(name = "category", nullable = true, length = 50)
    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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
    @Column(name = "iserror", nullable = true, length = -1)
    public String getIserror()
    {
        return iserror;
    }

    public void setIserror(String iserror)
    {
        this.iserror = iserror;
    }

    @Basic
    @Column(name = "text", nullable = true, length = -1)
    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NoteeventsEntity that = (NoteeventsEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && Objects.equals(hadmId, that.hadmId) && Objects.equals(chartdate, that.chartdate) && Objects.equals(charttime, that.charttime) && Objects.equals(storetime, that.storetime) && Objects.equals(category, that.category) && Objects.equals(description, that.description) && Objects.equals(cgid, that.cgid) && Objects.equals(iserror, that.iserror) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, chartdate, charttime, storetime, category, description, cgid, iserror, text);
    }
}
