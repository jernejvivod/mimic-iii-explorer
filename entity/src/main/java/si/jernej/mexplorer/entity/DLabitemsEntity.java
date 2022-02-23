package si.jernej.mexplorer.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_labitems", schema = "mimiciii", catalog = "mimic")
public class DLabitemsEntity
{
    private int rowId;
    private int itemid;
    private String label;
    private String fluid;
    private String category;
    private String loincCode;

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
    @Column(name = "label", nullable = false, length = 100)
    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    @Basic
    @Column(name = "fluid", nullable = false, length = 100)
    public String getFluid()
    {
        return fluid;
    }

    public void setFluid(String fluid)
    {
        this.fluid = fluid;
    }

    @Basic
    @Column(name = "category", nullable = false, length = 100)
    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    @Basic
    @Column(name = "loinc_code", nullable = true, length = 100)
    public String getLoincCode()
    {
        return loincCode;
    }

    public void setLoincCode(String loincCode)
    {
        this.loincCode = loincCode;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DLabitemsEntity that = (DLabitemsEntity) o;
        return rowId == that.rowId && itemid == that.itemid && Objects.equals(label, that.label) && Objects.equals(fluid, that.fluid) && Objects.equals(category, that.category) && Objects.equals(loincCode, that.loincCode);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, itemid, label, fluid, category, loincCode);
    }
}
