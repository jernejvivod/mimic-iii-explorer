package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "procedureevents_mv", schema = "mimiciii", catalog = "mimic")
public class ProcedureeventsMvEntity
{
    private int rowId;
    private int subjectId;
    private int hadmId;
    private Integer icustayId;
    private Timestamp starttime;
    private Timestamp endtime;
    private Integer itemid;
    private Double value;
    private String valueuom;
    private String location;
    private String locationcategory;
    private Timestamp storetime;
    private Integer cgid;
    private Integer orderid;
    private Integer linkorderid;
    private String ordercategoryname;
    private String secondaryordercategoryname;
    private String ordercategorydescription;
    private Short isopenbag;
    private Short continueinnextdept;
    private Short cancelreason;
    private String statusdescription;
    private String commentsEditedby;
    private String commentsCanceledby;
    private Timestamp commentsDate;

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
    @Column(name = "icustay_id", nullable = true)
    public Integer getIcustayId()
    {
        return icustayId;
    }

    public void setIcustayId(Integer icustayId)
    {
        this.icustayId = icustayId;
    }

    @Basic
    @Column(name = "starttime", nullable = true)
    public Timestamp getStarttime()
    {
        return starttime;
    }

    public void setStarttime(Timestamp starttime)
    {
        this.starttime = starttime;
    }

    @Basic
    @Column(name = "endtime", nullable = true)
    public Timestamp getEndtime()
    {
        return endtime;
    }

    public void setEndtime(Timestamp endtime)
    {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "itemid", nullable = true)
    public Integer getItemid()
    {
        return itemid;
    }

    public void setItemid(Integer itemid)
    {
        this.itemid = itemid;
    }

    @Basic
    @Column(name = "value", nullable = true, precision = 0)
    public Double getValue()
    {
        return value;
    }

    public void setValue(Double value)
    {
        this.value = value;
    }

    @Basic
    @Column(name = "valueuom", nullable = true, length = 30)
    public String getValueuom()
    {
        return valueuom;
    }

    public void setValueuom(String valueuom)
    {
        this.valueuom = valueuom;
    }

    @Basic
    @Column(name = "location", nullable = true, length = 30)
    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    @Basic
    @Column(name = "locationcategory", nullable = true, length = 30)
    public String getLocationcategory()
    {
        return locationcategory;
    }

    public void setLocationcategory(String locationcategory)
    {
        this.locationcategory = locationcategory;
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
    @Column(name = "orderid", nullable = true)
    public Integer getOrderid()
    {
        return orderid;
    }

    public void setOrderid(Integer orderid)
    {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "linkorderid", nullable = true)
    public Integer getLinkorderid()
    {
        return linkorderid;
    }

    public void setLinkorderid(Integer linkorderid)
    {
        this.linkorderid = linkorderid;
    }

    @Basic
    @Column(name = "ordercategoryname", nullable = true, length = 100)
    public String getOrdercategoryname()
    {
        return ordercategoryname;
    }

    public void setOrdercategoryname(String ordercategoryname)
    {
        this.ordercategoryname = ordercategoryname;
    }

    @Basic
    @Column(name = "secondaryordercategoryname", nullable = true, length = 100)
    public String getSecondaryordercategoryname()
    {
        return secondaryordercategoryname;
    }

    public void setSecondaryordercategoryname(String secondaryordercategoryname)
    {
        this.secondaryordercategoryname = secondaryordercategoryname;
    }

    @Basic
    @Column(name = "ordercategorydescription", nullable = true, length = 50)
    public String getOrdercategorydescription()
    {
        return ordercategorydescription;
    }

    public void setOrdercategorydescription(String ordercategorydescription)
    {
        this.ordercategorydescription = ordercategorydescription;
    }

    @Basic
    @Column(name = "isopenbag", nullable = true)
    public Short getIsopenbag()
    {
        return isopenbag;
    }

    public void setIsopenbag(Short isopenbag)
    {
        this.isopenbag = isopenbag;
    }

    @Basic
    @Column(name = "continueinnextdept", nullable = true)
    public Short getContinueinnextdept()
    {
        return continueinnextdept;
    }

    public void setContinueinnextdept(Short continueinnextdept)
    {
        this.continueinnextdept = continueinnextdept;
    }

    @Basic
    @Column(name = "cancelreason", nullable = true)
    public Short getCancelreason()
    {
        return cancelreason;
    }

    public void setCancelreason(Short cancelreason)
    {
        this.cancelreason = cancelreason;
    }

    @Basic
    @Column(name = "statusdescription", nullable = true, length = 30)
    public String getStatusdescription()
    {
        return statusdescription;
    }

    public void setStatusdescription(String statusdescription)
    {
        this.statusdescription = statusdescription;
    }

    @Basic
    @Column(name = "comments_editedby", nullable = true, length = 30)
    public String getCommentsEditedby()
    {
        return commentsEditedby;
    }

    public void setCommentsEditedby(String commentsEditedby)
    {
        this.commentsEditedby = commentsEditedby;
    }

    @Basic
    @Column(name = "comments_canceledby", nullable = true, length = 30)
    public String getCommentsCanceledby()
    {
        return commentsCanceledby;
    }

    public void setCommentsCanceledby(String commentsCanceledby)
    {
        this.commentsCanceledby = commentsCanceledby;
    }

    @Basic
    @Column(name = "comments_date", nullable = true)
    public Timestamp getCommentsDate()
    {
        return commentsDate;
    }

    public void setCommentsDate(Timestamp commentsDate)
    {
        this.commentsDate = commentsDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProcedureeventsMvEntity that = (ProcedureeventsMvEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && hadmId == that.hadmId && Objects.equals(icustayId, that.icustayId) && Objects.equals(starttime, that.starttime) && Objects.equals(endtime, that.endtime) && Objects.equals(itemid, that.itemid) && Objects.equals(value, that.value) && Objects.equals(valueuom, that.valueuom) && Objects.equals(location, that.location) && Objects.equals(locationcategory, that.locationcategory) && Objects.equals(storetime, that.storetime) && Objects.equals(cgid, that.cgid) && Objects.equals(orderid, that.orderid) && Objects.equals(linkorderid, that.linkorderid) && Objects.equals(ordercategoryname, that.ordercategoryname)
                && Objects.equals(secondaryordercategoryname, that.secondaryordercategoryname) && Objects.equals(ordercategorydescription, that.ordercategorydescription) && Objects.equals(isopenbag, that.isopenbag) && Objects.equals(continueinnextdept, that.continueinnextdept) && Objects.equals(cancelreason, that.cancelreason) && Objects.equals(statusdescription, that.statusdescription) && Objects.equals(commentsEditedby, that.commentsEditedby) && Objects.equals(commentsCanceledby, that.commentsCanceledby) && Objects.equals(commentsDate, that.commentsDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, icustayId, starttime, endtime, itemid, value, valueuom, location, locationcategory, storetime, cgid, orderid, linkorderid, ordercategoryname, secondaryordercategoryname, ordercategorydescription, isopenbag, continueinnextdept, cancelreason, statusdescription, commentsEditedby, commentsCanceledby, commentsDate);
    }
}
