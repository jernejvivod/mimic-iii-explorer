package si.jernej.mexplorer.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_cpt", schema = "mimiciii", catalog = "mimic")
public class DCptEntity
{
    private int rowId;
    private short category;
    private String sectionrange;
    private String sectionheader;
    private String subsectionrange;
    private String subsectionheader;
    private String codesuffix;
    private int mincodeinsubsection;
    private int maxcodeinsubsection;

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
    @Column(name = "category", nullable = false)
    public short getCategory()
    {
        return category;
    }

    public void setCategory(short category)
    {
        this.category = category;
    }

    @Basic
    @Column(name = "sectionrange", nullable = false, length = 100)
    public String getSectionrange()
    {
        return sectionrange;
    }

    public void setSectionrange(String sectionrange)
    {
        this.sectionrange = sectionrange;
    }

    @Basic
    @Column(name = "sectionheader", nullable = false, length = 50)
    public String getSectionheader()
    {
        return sectionheader;
    }

    public void setSectionheader(String sectionheader)
    {
        this.sectionheader = sectionheader;
    }

    @Basic
    @Column(name = "subsectionrange", nullable = false, length = 100)
    public String getSubsectionrange()
    {
        return subsectionrange;
    }

    public void setSubsectionrange(String subsectionrange)
    {
        this.subsectionrange = subsectionrange;
    }

    @Basic
    @Column(name = "subsectionheader", nullable = false, length = 255)
    public String getSubsectionheader()
    {
        return subsectionheader;
    }

    public void setSubsectionheader(String subsectionheader)
    {
        this.subsectionheader = subsectionheader;
    }

    @Basic
    @Column(name = "codesuffix", nullable = true, length = 5)
    public String getCodesuffix()
    {
        return codesuffix;
    }

    public void setCodesuffix(String codesuffix)
    {
        this.codesuffix = codesuffix;
    }

    @Basic
    @Column(name = "mincodeinsubsection", nullable = false)
    public int getMincodeinsubsection()
    {
        return mincodeinsubsection;
    }

    public void setMincodeinsubsection(int mincodeinsubsection)
    {
        this.mincodeinsubsection = mincodeinsubsection;
    }

    @Basic
    @Column(name = "maxcodeinsubsection", nullable = false)
    public int getMaxcodeinsubsection()
    {
        return maxcodeinsubsection;
    }

    public void setMaxcodeinsubsection(int maxcodeinsubsection)
    {
        this.maxcodeinsubsection = maxcodeinsubsection;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DCptEntity that = (DCptEntity) o;
        return rowId == that.rowId && category == that.category && mincodeinsubsection == that.mincodeinsubsection && maxcodeinsubsection == that.maxcodeinsubsection && Objects.equals(sectionrange, that.sectionrange) && Objects.equals(sectionheader, that.sectionheader) && Objects.equals(subsectionrange, that.subsectionrange) && Objects.equals(subsectionheader, that.subsectionheader) && Objects.equals(codesuffix, that.codesuffix);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, category, sectionrange, sectionheader, subsectionrange, subsectionheader, codesuffix, mincodeinsubsection, maxcodeinsubsection);
    }
}
