package si.jernej.mexplorer.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "procedures_icd", schema = "mimiciii", catalog = "mimic")
public class ProceduresIcdEntity
{
    private int rowId;
    private int subjectId;
    private int hadmId;
    private int seqNum;
    private String icd9Code;

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
    @Column(name = "seq_num", nullable = false)
    public int getSeqNum()
    {
        return seqNum;
    }

    public void setSeqNum(int seqNum)
    {
        this.seqNum = seqNum;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProceduresIcdEntity that = (ProceduresIcdEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && hadmId == that.hadmId && seqNum == that.seqNum && Objects.equals(icd9Code, that.icd9Code);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, seqNum, icd9Code);
    }
}
