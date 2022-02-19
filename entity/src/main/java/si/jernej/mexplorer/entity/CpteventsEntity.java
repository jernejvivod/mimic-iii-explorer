package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cptevents", schema = "mimiciii", catalog = "mimic")
public class CpteventsEntity
{
    private int rowId;
    private int subjectId;
    private int hadmId;
    private String costcenter;
    private Timestamp chartdate;
    private String cptCd;
    private Integer cptNumber;
    private String cptSuffix;
    private Integer ticketIdSeq;
    private String sectionheader;
    private String subsectionheader;
    private String description;

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
    @Column(name = "costcenter", nullable = false, length = 10)
    public String getCostcenter()
    {
        return costcenter;
    }

    public void setCostcenter(String costcenter)
    {
        this.costcenter = costcenter;
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
    @Column(name = "cpt_cd", nullable = false, length = 10)
    public String getCptCd()
    {
        return cptCd;
    }

    public void setCptCd(String cptCd)
    {
        this.cptCd = cptCd;
    }

    @Basic
    @Column(name = "cpt_number", nullable = true)
    public Integer getCptNumber()
    {
        return cptNumber;
    }

    public void setCptNumber(Integer cptNumber)
    {
        this.cptNumber = cptNumber;
    }

    @Basic
    @Column(name = "cpt_suffix", nullable = true, length = 5)
    public String getCptSuffix()
    {
        return cptSuffix;
    }

    public void setCptSuffix(String cptSuffix)
    {
        this.cptSuffix = cptSuffix;
    }

    @Basic
    @Column(name = "ticket_id_seq", nullable = true)
    public Integer getTicketIdSeq()
    {
        return ticketIdSeq;
    }

    public void setTicketIdSeq(Integer ticketIdSeq)
    {
        this.ticketIdSeq = ticketIdSeq;
    }

    @Basic
    @Column(name = "sectionheader", nullable = true, length = 50)
    public String getSectionheader()
    {
        return sectionheader;
    }

    public void setSectionheader(String sectionheader)
    {
        this.sectionheader = sectionheader;
    }

    @Basic
    @Column(name = "subsectionheader", nullable = true, length = 255)
    public String getSubsectionheader()
    {
        return subsectionheader;
    }

    public void setSubsectionheader(String subsectionheader)
    {
        this.subsectionheader = subsectionheader;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 200)
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CpteventsEntity that = (CpteventsEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && hadmId == that.hadmId && Objects.equals(costcenter, that.costcenter) && Objects.equals(chartdate, that.chartdate) && Objects.equals(cptCd, that.cptCd) && Objects.equals(cptNumber, that.cptNumber) && Objects.equals(cptSuffix, that.cptSuffix) && Objects.equals(ticketIdSeq, that.ticketIdSeq) && Objects.equals(sectionheader, that.sectionheader) && Objects.equals(subsectionheader, that.subsectionheader) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, costcenter, chartdate, cptCd, cptNumber, cptSuffix, ticketIdSeq, sectionheader, subsectionheader, description);
    }
}
