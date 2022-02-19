package si.jernej.mexplorer.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_items", schema = "mimiciii", catalog = "mimic")
public class DItemsEntity
{
    private int rowId;
    private int itemid;
    private String label;
    private String abbreviation;
    private String dbsource;
    private String linksto;
    private String category;
    private String unitname;
    private String paramType;
    private Integer conceptid;

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
    @Column(name = "label", nullable = true, length = 200)
    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    @Basic
    @Column(name = "abbreviation", nullable = true, length = 100)
    public String getAbbreviation()
    {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    @Basic
    @Column(name = "dbsource", nullable = true, length = 20)
    public String getDbsource()
    {
        return dbsource;
    }

    public void setDbsource(String dbsource)
    {
        this.dbsource = dbsource;
    }

    @Basic
    @Column(name = "linksto", nullable = true, length = 50)
    public String getLinksto()
    {
        return linksto;
    }

    public void setLinksto(String linksto)
    {
        this.linksto = linksto;
    }

    @Basic
    @Column(name = "category", nullable = true, length = 100)
    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    @Basic
    @Column(name = "unitname", nullable = true, length = 100)
    public String getUnitname()
    {
        return unitname;
    }

    public void setUnitname(String unitname)
    {
        this.unitname = unitname;
    }

    @Basic
    @Column(name = "param_type", nullable = true, length = 30)
    public String getParamType()
    {
        return paramType;
    }

    public void setParamType(String paramType)
    {
        this.paramType = paramType;
    }

    @Basic
    @Column(name = "conceptid", nullable = true)
    public Integer getConceptid()
    {
        return conceptid;
    }

    public void setConceptid(Integer conceptid)
    {
        this.conceptid = conceptid;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DItemsEntity that = (DItemsEntity) o;
        return rowId == that.rowId && itemid == that.itemid && Objects.equals(label, that.label) && Objects.equals(abbreviation, that.abbreviation) && Objects.equals(dbsource, that.dbsource) && Objects.equals(linksto, that.linksto) && Objects.equals(category, that.category) && Objects.equals(unitname, that.unitname) && Objects.equals(paramType, that.paramType) && Objects.equals(conceptid, that.conceptid);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, itemid, label, abbreviation, dbsource, linksto, category, unitname, paramType, conceptid);
    }
}
