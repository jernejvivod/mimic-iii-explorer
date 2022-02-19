package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inputevents_mv", schema = "mimiciii", catalog = "mimic")
public class InputeventsMvEntity
{
    private int rowId;
    private int subjectId;
    private Integer hadmId;
    private Integer icustayId;
    private Timestamp starttime;
    private Timestamp endtime;
    private Integer itemid;
    private Double amount;
    private String amountuom;
    private Double rate;
    private String rateuom;
    private Timestamp storetime;
    private Integer cgid;
    private Integer orderid;
    private Integer linkorderid;
    private String ordercategoryname;
    private String secondaryordercategoryname;
    private String ordercomponenttypedescription;
    private String ordercategorydescription;
    private Double patientweight;
    private Double totalamount;
    private String totalamountuom;
    private Short isopenbag;
    private Short continueinnextdept;
    private Short cancelreason;
    private String statusdescription;
    private String commentsEditedby;
    private String commentsCanceledby;
    private Timestamp commentsDate;
    private Double originalamount;
    private Double originalrate;

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
    @Column(name = "amount", nullable = true, precision = 0)
    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    @Basic
    @Column(name = "amountuom", nullable = true, length = 30)
    public String getAmountuom()
    {
        return amountuom;
    }

    public void setAmountuom(String amountuom)
    {
        this.amountuom = amountuom;
    }

    @Basic
    @Column(name = "rate", nullable = true, precision = 0)
    public Double getRate()
    {
        return rate;
    }

    public void setRate(Double rate)
    {
        this.rate = rate;
    }

    @Basic
    @Column(name = "rateuom", nullable = true, length = 30)
    public String getRateuom()
    {
        return rateuom;
    }

    public void setRateuom(String rateuom)
    {
        this.rateuom = rateuom;
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
    @Column(name = "ordercomponenttypedescription", nullable = true, length = 200)
    public String getOrdercomponenttypedescription()
    {
        return ordercomponenttypedescription;
    }

    public void setOrdercomponenttypedescription(String ordercomponenttypedescription)
    {
        this.ordercomponenttypedescription = ordercomponenttypedescription;
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
    @Column(name = "patientweight", nullable = true, precision = 0)
    public Double getPatientweight()
    {
        return patientweight;
    }

    public void setPatientweight(Double patientweight)
    {
        this.patientweight = patientweight;
    }

    @Basic
    @Column(name = "totalamount", nullable = true, precision = 0)
    public Double getTotalamount()
    {
        return totalamount;
    }

    public void setTotalamount(Double totalamount)
    {
        this.totalamount = totalamount;
    }

    @Basic
    @Column(name = "totalamountuom", nullable = true, length = 50)
    public String getTotalamountuom()
    {
        return totalamountuom;
    }

    public void setTotalamountuom(String totalamountuom)
    {
        this.totalamountuom = totalamountuom;
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
    @Column(name = "comments_canceledby", nullable = true, length = 40)
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

    @Basic
    @Column(name = "originalamount", nullable = true, precision = 0)
    public Double getOriginalamount()
    {
        return originalamount;
    }

    public void setOriginalamount(Double originalamount)
    {
        this.originalamount = originalamount;
    }

    @Basic
    @Column(name = "originalrate", nullable = true, precision = 0)
    public Double getOriginalrate()
    {
        return originalrate;
    }

    public void setOriginalrate(Double originalrate)
    {
        this.originalrate = originalrate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        InputeventsMvEntity that = (InputeventsMvEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && Objects.equals(hadmId, that.hadmId) && Objects.equals(icustayId, that.icustayId) && Objects.equals(starttime, that.starttime) && Objects.equals(endtime, that.endtime) && Objects.equals(itemid, that.itemid) && Objects.equals(amount, that.amount) && Objects.equals(amountuom, that.amountuom) && Objects.equals(rate, that.rate) && Objects.equals(rateuom, that.rateuom) && Objects.equals(storetime, that.storetime) && Objects.equals(cgid, that.cgid) && Objects.equals(orderid, that.orderid) && Objects.equals(linkorderid, that.linkorderid) && Objects.equals(ordercategoryname,
                that.ordercategoryname) && Objects.equals(secondaryordercategoryname, that.secondaryordercategoryname) && Objects.equals(ordercomponenttypedescription, that.ordercomponenttypedescription) && Objects.equals(ordercategorydescription, that.ordercategorydescription) && Objects.equals(patientweight, that.patientweight) && Objects.equals(totalamount, that.totalamount) && Objects.equals(totalamountuom, that.totalamountuom) && Objects.equals(isopenbag, that.isopenbag) && Objects.equals(continueinnextdept, that.continueinnextdept) && Objects.equals(cancelreason, that.cancelreason) && Objects.equals(statusdescription, that.statusdescription) && Objects.equals(commentsEditedby,
                that.commentsEditedby) && Objects.equals(commentsCanceledby, that.commentsCanceledby) && Objects.equals(commentsDate, that.commentsDate) && Objects.equals(originalamount, that.originalamount) && Objects.equals(originalrate, that.originalrate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, icustayId, starttime, endtime, itemid, amount, amountuom, rate, rateuom, storetime, cgid, orderid, linkorderid, ordercategoryname, secondaryordercategoryname, ordercomponenttypedescription, ordercategorydescription, patientweight, totalamount, totalamountuom, isopenbag, continueinnextdept, cancelreason, statusdescription, commentsEditedby, commentsCanceledby, commentsDate, originalamount, originalrate);
    }
}
