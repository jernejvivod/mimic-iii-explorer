package si.jernej.mexplorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prescriptions", schema = "mimiciii", catalog = "mimic")
public class PrescriptionsEntity
{
    private int rowId;
    private int subjectId;
    private int hadmId;
    private Integer icustayId;
    private Timestamp startdate;
    private Timestamp enddate;
    private String drugType;
    private String drug;
    private String drugNamePoe;
    private String drugNameGeneric;
    private String formularyDrugCd;
    private String gsn;
    private String ndc;
    private String prodStrength;
    private String doseValRx;
    private String doseUnitRx;
    private String formValDisp;
    private String formUnitDisp;
    private String route;

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
    @Column(name = "startdate", nullable = true)
    public Timestamp getStartdate()
    {
        return startdate;
    }

    public void setStartdate(Timestamp startdate)
    {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "enddate", nullable = true)
    public Timestamp getEnddate()
    {
        return enddate;
    }

    public void setEnddate(Timestamp enddate)
    {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "drug_type", nullable = false, length = 100)
    public String getDrugType()
    {
        return drugType;
    }

    public void setDrugType(String drugType)
    {
        this.drugType = drugType;
    }

    @Basic
    @Column(name = "drug", nullable = false, length = 100)
    public String getDrug()
    {
        return drug;
    }

    public void setDrug(String drug)
    {
        this.drug = drug;
    }

    @Basic
    @Column(name = "drug_name_poe", nullable = true, length = 100)
    public String getDrugNamePoe()
    {
        return drugNamePoe;
    }

    public void setDrugNamePoe(String drugNamePoe)
    {
        this.drugNamePoe = drugNamePoe;
    }

    @Basic
    @Column(name = "drug_name_generic", nullable = true, length = 100)
    public String getDrugNameGeneric()
    {
        return drugNameGeneric;
    }

    public void setDrugNameGeneric(String drugNameGeneric)
    {
        this.drugNameGeneric = drugNameGeneric;
    }

    @Basic
    @Column(name = "formulary_drug_cd", nullable = true, length = 120)
    public String getFormularyDrugCd()
    {
        return formularyDrugCd;
    }

    public void setFormularyDrugCd(String formularyDrugCd)
    {
        this.formularyDrugCd = formularyDrugCd;
    }

    @Basic
    @Column(name = "gsn", nullable = true, length = 200)
    public String getGsn()
    {
        return gsn;
    }

    public void setGsn(String gsn)
    {
        this.gsn = gsn;
    }

    @Basic
    @Column(name = "ndc", nullable = true, length = 120)
    public String getNdc()
    {
        return ndc;
    }

    public void setNdc(String ndc)
    {
        this.ndc = ndc;
    }

    @Basic
    @Column(name = "prod_strength", nullable = true, length = 120)
    public String getProdStrength()
    {
        return prodStrength;
    }

    public void setProdStrength(String prodStrength)
    {
        this.prodStrength = prodStrength;
    }

    @Basic
    @Column(name = "dose_val_rx", nullable = true, length = 120)
    public String getDoseValRx()
    {
        return doseValRx;
    }

    public void setDoseValRx(String doseValRx)
    {
        this.doseValRx = doseValRx;
    }

    @Basic
    @Column(name = "dose_unit_rx", nullable = true, length = 120)
    public String getDoseUnitRx()
    {
        return doseUnitRx;
    }

    public void setDoseUnitRx(String doseUnitRx)
    {
        this.doseUnitRx = doseUnitRx;
    }

    @Basic
    @Column(name = "form_val_disp", nullable = true, length = 120)
    public String getFormValDisp()
    {
        return formValDisp;
    }

    public void setFormValDisp(String formValDisp)
    {
        this.formValDisp = formValDisp;
    }

    @Basic
    @Column(name = "form_unit_disp", nullable = true, length = 120)
    public String getFormUnitDisp()
    {
        return formUnitDisp;
    }

    public void setFormUnitDisp(String formUnitDisp)
    {
        this.formUnitDisp = formUnitDisp;
    }

    @Basic
    @Column(name = "route", nullable = true, length = 120)
    public String getRoute()
    {
        return route;
    }

    public void setRoute(String route)
    {
        this.route = route;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PrescriptionsEntity that = (PrescriptionsEntity) o;
        return rowId == that.rowId && subjectId == that.subjectId && hadmId == that.hadmId && Objects.equals(icustayId, that.icustayId) && Objects.equals(startdate, that.startdate) && Objects.equals(enddate, that.enddate) && Objects.equals(drugType, that.drugType) && Objects.equals(drug, that.drug) && Objects.equals(drugNamePoe, that.drugNamePoe) && Objects.equals(drugNameGeneric, that.drugNameGeneric) && Objects.equals(formularyDrugCd, that.formularyDrugCd) && Objects.equals(gsn, that.gsn) && Objects.equals(ndc, that.ndc) && Objects.equals(prodStrength, that.prodStrength) && Objects.equals(doseValRx, that.doseValRx) && Objects.equals(doseUnitRx, that.doseUnitRx)
                && Objects.equals(formValDisp, that.formValDisp) && Objects.equals(formUnitDisp, that.formUnitDisp) && Objects.equals(route, that.route);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowId, subjectId, hadmId, icustayId, startdate, enddate, drugType, drug, drugNamePoe, drugNameGeneric, formularyDrugCd, gsn, ndc, prodStrength, doseValRx, doseUnitRx, formValDisp, formUnitDisp, route);
    }
}
