package si.jernej.mexplorer.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drgcodes", schema = "mimiciii", catalog = "mimic")
public class DrgcodesEntity
{
    private int rowId;
    private int subjectId;
    private int hadmId;
    private String drgType;
    private String drgCode;
    private String description;
    private Short drgSeverity;
    private Short drgMortality;

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
    @Column(name = "drg_type", nullable = false, length = 20)
    public String getDrgType()
    {
        return drgType;
    }

    public void setDrgType(String drgType)
    {
        this.drgType = drgType;
    }

    @Basic
    @Column(name = "drg_code", nullable = false, length = 20)
    public String getDrgCode()
    {
        return drgCode;
    }

    public void setDrgCode(String drgCode)
    {
        this.drgCode = drgCode;
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
    @Column(name = "drg_severity", nullable = true)
    public Short getDrgSeverity()
    {
        return drgSeverity;
    }

    public void setDrgSeverity(Short drgSeverity)
    {
        this.drgSeverity = drgSeverity;
    }

    @Basic
    @Column(name = "drg_mortality", nullable = true)
    public Short getDrgMortality()
    {
        return drgMortality;
    }

    public void setDrgMortality(Short drgMortality)
    {
        this.drgMortality = drgMortality;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DrgcodesEntity that = (DrgcodesEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && hadmId == that.hadmId && Objects.equals(drgType, that.drgType) && Objects.equals(drgCode, that.drgCode) && Objects.equals(description, that.description) && Objects.equals(drgSeverity, that.drgSeverity) && Objects.equals(drgMortality, that.drgMortality);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, drgType, drgCode, description, drgSeverity, drgMortality);
    }
}
