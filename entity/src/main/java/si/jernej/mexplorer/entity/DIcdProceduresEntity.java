package si.jernej.mexplorer.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_icd_procedures", schema = "mimiciii", catalog = "mimic")
public class DIcdProceduresEntity
{
    private int rowId;
    private String icd9Code;
    private String shortTitle;
    private String longTitle;

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
    @Column(name = "icd9_code", nullable = false, length = 10)
    public String getIcd9Code()
    {
        return icd9Code;
    }

    public void setIcd9Code(String icd9Code)
    {
        this.icd9Code = icd9Code;
    }

    @Basic
    @Column(name = "short_title", nullable = false, length = 50)
    public String getShortTitle()
    {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle)
    {
        this.shortTitle = shortTitle;
    }

    @Basic
    @Column(name = "long_title", nullable = false, length = 255)
    public String getLongTitle()
    {
        return longTitle;
    }

    public void setLongTitle(String longTitle)
    {
        this.longTitle = longTitle;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DIcdProceduresEntity that = (DIcdProceduresEntity) o;
        return rowId == that.rowId && Objects.equals(icd9Code, that.icd9Code) && Objects.equals(shortTitle, that.shortTitle) && Objects.equals(longTitle, that.longTitle);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, icd9Code, shortTitle, longTitle);
    }
}
