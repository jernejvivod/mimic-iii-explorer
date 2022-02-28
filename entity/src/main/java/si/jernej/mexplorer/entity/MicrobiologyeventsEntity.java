package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "microbiologyevents", schema = "mimiciii", catalog = "mimic")
public class MicrobiologyeventsEntity
{
    private int rowId;
    private int subjectId;
    private Integer hadmId;
    private Timestamp chartdate;
    private Timestamp charttime;
    private Integer specItemid;
    private String specTypeDesc;
    private Integer orgItemid;
    private String orgName;
    private Short isolateNum;
    private Integer abItemid;
    private String abName;
    private String dilutionText;
    private String dilutionComparison;
    private Double dilutionValue;
    private String interpretation;

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
    @Column(name = "spec_itemid", nullable = true)
    public Integer getSpecItemid()
    {
        return specItemid;
    }

    public void setSpecItemid(Integer specItemid)
    {
        this.specItemid = specItemid;
    }

    @Basic
    @Column(name = "spec_type_desc", nullable = true, length = 100)
    public String getSpecTypeDesc()
    {
        return specTypeDesc;
    }

    public void setSpecTypeDesc(String specTypeDesc)
    {
        this.specTypeDesc = specTypeDesc;
    }

    @Basic
    @Column(name = "org_itemid", nullable = true)
    public Integer getOrgItemid()
    {
        return orgItemid;
    }

    public void setOrgItemid(Integer orgItemid)
    {
        this.orgItemid = orgItemid;
    }

    @Basic
    @Column(name = "org_name", nullable = true, length = 100)
    public String getOrgName()
    {
        return orgName;
    }

    public void setOrgName(String orgName)
    {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "isolate_num", nullable = true)
    public Short getIsolateNum()
    {
        return isolateNum;
    }

    public void setIsolateNum(Short isolateNum)
    {
        this.isolateNum = isolateNum;
    }

    @Basic
    @Column(name = "ab_itemid", nullable = true)
    public Integer getAbItemid()
    {
        return abItemid;
    }

    public void setAbItemid(Integer abItemid)
    {
        this.abItemid = abItemid;
    }

    @Basic
    @Column(name = "ab_name", nullable = true, length = 30)
    public String getAbName()
    {
        return abName;
    }

    public void setAbName(String abName)
    {
        this.abName = abName;
    }

    @Basic
    @Column(name = "dilution_text", nullable = true, length = 10)
    public String getDilutionText()
    {
        return dilutionText;
    }

    public void setDilutionText(String dilutionText)
    {
        this.dilutionText = dilutionText;
    }

    @Basic
    @Column(name = "dilution_comparison", nullable = true, length = 20)
    public String getDilutionComparison()
    {
        return dilutionComparison;
    }

    public void setDilutionComparison(String dilutionComparison)
    {
        this.dilutionComparison = dilutionComparison;
    }

    @Basic
    @Column(name = "dilution_value", nullable = true, precision = 0)
    public Double getDilutionValue()
    {
        return dilutionValue;
    }

    public void setDilutionValue(Double dilutionValue)
    {
        this.dilutionValue = dilutionValue;
    }

    @Basic
    @Column(name = "interpretation", nullable = true, length = 5)
    public String getInterpretation()
    {
        return interpretation;
    }

    public void setInterpretation(String interpretation)
    {
        this.interpretation = interpretation;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MicrobiologyeventsEntity that = (MicrobiologyeventsEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && Objects.equals(hadmId, that.hadmId) && Objects.equals(chartdate, that.chartdate) && Objects.equals(charttime, that.charttime) && Objects.equals(specItemid, that.specItemid) && Objects.equals(specTypeDesc, that.specTypeDesc) && Objects.equals(orgItemid, that.orgItemid) && Objects.equals(orgName, that.orgName) && Objects.equals(isolateNum, that.isolateNum) && Objects.equals(abItemid, that.abItemid) && Objects.equals(abName, that.abName) && Objects.equals(dilutionText, that.dilutionText) && Objects.equals(dilutionComparison, that.dilutionComparison) && Objects.equals(dilutionValue, that.dilutionValue)
                && Objects.equals(interpretation, that.interpretation);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, chartdate, charttime, specItemid, specTypeDesc, orgItemid, orgName, isolateNum, abItemid, abName, dilutionText, dilutionComparison, dilutionValue, interpretation);
    }
}
