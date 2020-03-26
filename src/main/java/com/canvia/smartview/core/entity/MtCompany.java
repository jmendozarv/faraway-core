package com.canvia.smartview.core.entity;

import com.canvia.smartview.core.entity.base.Audit;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "mt_company")
@NamedQueries({
    @NamedQuery(name = "MtCompany.findAll", query = "SELECT d FROM MtCompany d")})
public class MtCompany extends Audit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="MTCOMPANY_COMPANYID_GENERATOR", sequenceName="SQ_COMPANY", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MTCOMPANY_COMPANYID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    @Basic(optional = false)
    private String companyName;

    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name = "doctype_code", referencedColumnName = "code", insertable = false, updatable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(value = "'DOCUMENT_TYPE'", referencedColumnName = "parent_group"))
    })
    @ManyToOne(fetch = FetchType.LAZY)
    private MtParameter doctype;

    @Column(name = "document_number")
    @Basic(optional = false)
    private String documentNumber;

    @Column(name = "legal_representative")
    @Basic(optional = false)
    private String legalRepresentative;

    @Column(name = "business_name")
    @Basic(optional = false)
    private String businessName;

    @Column(name = "main_color")
    @Basic(optional = false)
    private String mainColor;

    @Column(name = "secondary_color")
    @Basic(optional = false)
    private String secondaryColor;

    @Column(name = "logo")
    @Basic(optional = false)
    private String logo;

    @Column(name = "background_image")
    @Basic(optional = false)
    private String backgroundImage;

    @Column(name = "website")
    @Basic(optional = false)
    private String website;

    @Column(name = "cms_sitename")
    @Basic(optional = false)
    private String cmsSitename;

    @ManyToMany(mappedBy = "companyList")
    private List<MtUser> userList;

    public MtCompany() {
    }

    public MtCompany(Long companyId) {
        this.companyId = companyId;
    }

    public MtCompany(Long companyId, String companyName, String mainColor, String secondaryColor, String logo, String backgroundImage, String cmsSitename) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.mainColor = mainColor;
        this.secondaryColor = secondaryColor;
        this.logo = logo;
        this.backgroundImage = backgroundImage;
        this.cmsSitename = cmsSitename;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public MtParameter getDoctype() {
        return doctype;
    }

    public void setDoctype(MtParameter doctype) {
        this.doctype = doctype;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCmsSitename() {
        return cmsSitename;
    }

    public void setCmsSitename(String cmsSitename) {
        this.cmsSitename = cmsSitename;
    }

    public List<MtUser> getUserList() {
        return userList;
    }

    public void setUserList(List<MtUser> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MtCompany)) {
            return false;
        }
        MtCompany other = (MtCompany) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.canvia.smartview.core.entity.MtCompany[ companyId=" + companyId + " ]";
    }
    
}
