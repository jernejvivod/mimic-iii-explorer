package si.jernej.mexplorer.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "caregivers", schema = "mimiciii", catalog = "mimic")
public class CaregiversEntity
{
    private int rowId;
    private int cgid;
    private String label;
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
    @Column(name = "cgid", nullable = false)
    public int getCgid()
    {
        return cgid;
    }

    public void setCgid(int cgid)
    {
        this.cgid = cgid;
    }

    @Basic
    @Column(name = "label", nullable = true, length = 15)
    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 30)
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
        CaregiversEntity that = (CaregiversEntity) o;
        return rowId == that.rowId && cgid == that.cgid && Objects.equals(label, that.label) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, cgid, label, description);
    }
}
