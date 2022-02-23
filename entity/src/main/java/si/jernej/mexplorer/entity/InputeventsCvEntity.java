package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inputevents_cv", schema = "mimiciii", catalog = "mimic")
public class InputeventsCvEntity
{
    private int rowId;
    private int subjectId;
    private Integer hadmId;
    private Integer icustayId;
    private Timestamp charttime;
    private Integer itemid;
    private Double amount;
    private String amountuom;
    private Double rate;
    private String rateuom;
    private Timestamp storetime;
    private Integer cgid;
    private Integer orderid;
    private Integer linkorderid;
    private String stopped;
    private Integer newbottle;
    private Double originalamount;
    private String originalamountuom;
    private String originalroute;
    private Double originalrate;
    private String originalrateuom;
    private String originalsite;

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
    @Column(name = "stopped", nullable = true, length = 30)
    public String getStopped()
    {
        return stopped;
    }

    public void setStopped(String stopped)
    {
        this.stopped = stopped;
    }

    @Basic
    @Column(name = "newbottle", nullable = true)
    public Integer getNewbottle()
    {
        return newbottle;
    }

    public void setNewbottle(Integer newbottle)
    {
        this.newbottle = newbottle;
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
    @Column(name = "originalamountuom", nullable = true, length = 30)
    public String getOriginalamountuom()
    {
        return originalamountuom;
    }

    public void setOriginalamountuom(String originalamountuom)
    {
        this.originalamountuom = originalamountuom;
    }

    @Basic
    @Column(name = "originalroute", nullable = true, length = 30)
    public String getOriginalroute()
    {
        return originalroute;
    }

    public void setOriginalroute(String originalroute)
    {
        this.originalroute = originalroute;
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

    @Basic
    @Column(name = "originalrateuom", nullable = true, length = 30)
    public String getOriginalrateuom()
    {
        return originalrateuom;
    }

    public void setOriginalrateuom(String originalrateuom)
    {
        this.originalrateuom = originalrateuom;
    }

    @Basic
    @Column(name = "originalsite", nullable = true, length = 30)
    public String getOriginalsite()
    {
        return originalsite;
    }

    public void setOriginalsite(String originalsite)
    {
        this.originalsite = originalsite;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        InputeventsCvEntity that = (InputeventsCvEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && Objects.equals(hadmId, that.hadmId) && Objects.equals(icustayId, that.icustayId) && Objects.equals(charttime, that.charttime) && Objects.equals(itemid, that.itemid) && Objects.equals(amount, that.amount) && Objects.equals(amountuom, that.amountuom) && Objects.equals(rate, that.rate) && Objects.equals(rateuom, that.rateuom) && Objects.equals(storetime, that.storetime) && Objects.equals(cgid, that.cgid) && Objects.equals(orderid, that.orderid) && Objects.equals(linkorderid, that.linkorderid) && Objects.equals(stopped, that.stopped) && Objects.equals(newbottle, that.newbottle)
                && Objects.equals(originalamount, that.originalamount) && Objects.equals(originalamountuom, that.originalamountuom) && Objects.equals(originalroute, that.originalroute) && Objects.equals(originalrate, that.originalrate) && Objects.equals(originalrateuom, that.originalrateuom) && Objects.equals(originalsite, that.originalsite);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, icustayId, charttime, itemid, amount, amountuom, rate, rateuom, storetime, cgid, orderid, linkorderid, stopped, newbottle, originalamount, originalamountuom, originalroute, originalrate, originalrateuom, originalsite);
    }
}
