package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "callout", schema = "mimiciii", catalog = "mimic")
public class CalloutEntity
{
    private int rowId;
    private int subjectId;
    private int hadmId;
    private Integer submitWardid;
    private String submitCareunit;
    private Integer currWardid;
    private String currCareunit;
    private Integer calloutWardid;
    private String calloutService;
    private short requestTele;
    private short requestResp;
    private short requestCdiff;
    private short requestMrsa;
    private short requestVre;
    private String calloutStatus;
    private String calloutOutcome;
    private Integer dischargeWardid;
    private String acknowledgeStatus;
    private Timestamp createtime;
    private Timestamp updatetime;
    private Timestamp acknowledgetime;
    private Timestamp outcometime;
    private Timestamp firstreservationtime;
    private Timestamp currentreservationtime;

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
    @Column(name = "submit_wardid", nullable = true)
    public Integer getSubmitWardid()
    {
        return submitWardid;
    }

    public void setSubmitWardid(Integer submitWardid)
    {
        this.submitWardid = submitWardid;
    }

    @Basic
    @Column(name = "submit_careunit", nullable = true, length = 15)
    public String getSubmitCareunit()
    {
        return submitCareunit;
    }

    public void setSubmitCareunit(String submitCareunit)
    {
        this.submitCareunit = submitCareunit;
    }

    @Basic
    @Column(name = "curr_wardid", nullable = true)
    public Integer getCurrWardid()
    {
        return currWardid;
    }

    public void setCurrWardid(Integer currWardid)
    {
        this.currWardid = currWardid;
    }

    @Basic
    @Column(name = "curr_careunit", nullable = true, length = 15)
    public String getCurrCareunit()
    {
        return currCareunit;
    }

    public void setCurrCareunit(String currCareunit)
    {
        this.currCareunit = currCareunit;
    }

    @Basic
    @Column(name = "callout_wardid", nullable = true)
    public Integer getCalloutWardid()
    {
        return calloutWardid;
    }

    public void setCalloutWardid(Integer calloutWardid)
    {
        this.calloutWardid = calloutWardid;
    }

    @Basic
    @Column(name = "callout_service", nullable = false, length = 10)
    public String getCalloutService()
    {
        return calloutService;
    }

    public void setCalloutService(String calloutService)
    {
        this.calloutService = calloutService;
    }

    @Basic
    @Column(name = "request_tele", nullable = false)
    public short getRequestTele()
    {
        return requestTele;
    }

    public void setRequestTele(short requestTele)
    {
        this.requestTele = requestTele;
    }

    @Basic
    @Column(name = "request_resp", nullable = false)
    public short getRequestResp()
    {
        return requestResp;
    }

    public void setRequestResp(short requestResp)
    {
        this.requestResp = requestResp;
    }

    @Basic
    @Column(name = "request_cdiff", nullable = false)
    public short getRequestCdiff()
    {
        return requestCdiff;
    }

    public void setRequestCdiff(short requestCdiff)
    {
        this.requestCdiff = requestCdiff;
    }

    @Basic
    @Column(name = "request_mrsa", nullable = false)
    public short getRequestMrsa()
    {
        return requestMrsa;
    }

    public void setRequestMrsa(short requestMrsa)
    {
        this.requestMrsa = requestMrsa;
    }

    @Basic
    @Column(name = "request_vre", nullable = false)
    public short getRequestVre()
    {
        return requestVre;
    }

    public void setRequestVre(short requestVre)
    {
        this.requestVre = requestVre;
    }

    @Basic
    @Column(name = "callout_status", nullable = false, length = 20)
    public String getCalloutStatus()
    {
        return calloutStatus;
    }

    public void setCalloutStatus(String calloutStatus)
    {
        this.calloutStatus = calloutStatus;
    }

    @Basic
    @Column(name = "callout_outcome", nullable = false, length = 20)
    public String getCalloutOutcome()
    {
        return calloutOutcome;
    }

    public void setCalloutOutcome(String calloutOutcome)
    {
        this.calloutOutcome = calloutOutcome;
    }

    @Basic
    @Column(name = "discharge_wardid", nullable = true)
    public Integer getDischargeWardid()
    {
        return dischargeWardid;
    }

    public void setDischargeWardid(Integer dischargeWardid)
    {
        this.dischargeWardid = dischargeWardid;
    }

    @Basic
    @Column(name = "acknowledge_status", nullable = false, length = 20)
    public String getAcknowledgeStatus()
    {
        return acknowledgeStatus;
    }

    public void setAcknowledgeStatus(String acknowledgeStatus)
    {
        this.acknowledgeStatus = acknowledgeStatus;
    }

    @Basic
    @Column(name = "createtime", nullable = false)
    public Timestamp getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime)
    {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "updatetime", nullable = false)
    public Timestamp getUpdatetime()
    {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime)
    {
        this.updatetime = updatetime;
    }

    @Basic
    @Column(name = "acknowledgetime", nullable = true)
    public Timestamp getAcknowledgetime()
    {
        return acknowledgetime;
    }

    public void setAcknowledgetime(Timestamp acknowledgetime)
    {
        this.acknowledgetime = acknowledgetime;
    }

    @Basic
    @Column(name = "outcometime", nullable = false)
    public Timestamp getOutcometime()
    {
        return outcometime;
    }

    public void setOutcometime(Timestamp outcometime)
    {
        this.outcometime = outcometime;
    }

    @Basic
    @Column(name = "firstreservationtime", nullable = true)
    public Timestamp getFirstreservationtime()
    {
        return firstreservationtime;
    }

    public void setFirstreservationtime(Timestamp firstreservationtime)
    {
        this.firstreservationtime = firstreservationtime;
    }

    @Basic
    @Column(name = "currentreservationtime", nullable = true)
    public Timestamp getCurrentreservationtime()
    {
        return currentreservationtime;
    }

    public void setCurrentreservationtime(Timestamp currentreservationtime)
    {
        this.currentreservationtime = currentreservationtime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CalloutEntity that = (CalloutEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && hadmId == that.hadmId && requestTele == that.requestTele && requestResp == that.requestResp && requestCdiff == that.requestCdiff && requestMrsa == that.requestMrsa && requestVre == that.requestVre && Objects.equals(submitWardid, that.submitWardid) && Objects.equals(submitCareunit, that.submitCareunit) && Objects.equals(currWardid, that.currWardid) && Objects.equals(currCareunit, that.currCareunit) && Objects.equals(calloutWardid, that.calloutWardid) && Objects.equals(calloutService, that.calloutService) && Objects.equals(calloutStatus, that.calloutStatus) && Objects.equals(calloutOutcome, that.calloutOutcome) && Objects.equals(
                dischargeWardid, that.dischargeWardid) && Objects.equals(acknowledgeStatus, that.acknowledgeStatus) && Objects.equals(createtime, that.createtime) && Objects.equals(updatetime, that.updatetime) && Objects.equals(acknowledgetime, that.acknowledgetime) && Objects.equals(outcometime, that.outcometime) && Objects.equals(firstreservationtime, that.firstreservationtime) && Objects.equals(currentreservationtime, that.currentreservationtime);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, submitWardid, submitCareunit, currWardid, currCareunit, calloutWardid, calloutService, requestTele, requestResp, requestCdiff, requestMrsa, requestVre, calloutStatus, calloutOutcome, dischargeWardid, acknowledgeStatus, createtime, updatetime, acknowledgetime, outcometime, firstreservationtime, currentreservationtime);
    }
}
