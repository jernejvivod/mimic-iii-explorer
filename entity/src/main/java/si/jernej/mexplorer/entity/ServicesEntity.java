package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "services", schema = "mimiciii", catalog = "mimic")
public class ServicesEntity
{
    private int rowId;
    private int subjectId;
    private int hadmId;
    private Timestamp transfertime;
    private String prevService;
    private String currService;

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
    @Column(name = "transfertime", nullable = false)
    public Timestamp getTransfertime()
    {
        return transfertime;
    }

    public void setTransfertime(Timestamp transfertime)
    {
        this.transfertime = transfertime;
    }

    @Basic
    @Column(name = "prev_service", nullable = true, length = 20)
    public String getPrevService()
    {
        return prevService;
    }

    public void setPrevService(String prevService)
    {
        this.prevService = prevService;
    }

    @Basic
    @Column(name = "curr_service", nullable = true, length = 20)
    public String getCurrService()
    {
        return currService;
    }

    public void setCurrService(String currService)
    {
        this.currService = currService;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ServicesEntity that = (ServicesEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && hadmId == that.hadmId && Objects.equals(transfertime, that.transfertime) && Objects.equals(prevService, that.prevService) && Objects.equals(currService, that.currService);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, transfertime, prevService, currService);
    }
}
