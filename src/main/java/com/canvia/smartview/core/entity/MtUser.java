package com.canvia.smartview.core.entity;

import com.canvia.smartview.core.entity.base.Audit;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "mt_user")
@NamedQueries({
    @NamedQuery(name = "MtUser.findAll", query = "SELECT d FROM MtUser d")})
public class MtUser extends Audit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="MTUSER_USERID_GENERATOR", sequenceName="SQ_USER", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MTUSER_USERID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    @Basic(optional = false)
    private String username;

    @Column(name = "password")
    @Basic(optional = false)
    private String password;

    @Column(name = "firstname")
    @Basic(optional = false)
    private String firstname;

    @Column(name = "lastname")
    @Basic(optional = false)
    private String lastname;

    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name = "doctype_code", referencedColumnName = "code", insertable = false, updatable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(value = "'DOCUMENT_TYPE'", referencedColumnName = "parent_group"))
    })
    @ManyToOne(fetch = FetchType.LAZY)
    private MtParameter doctype;

    @Column(name = "document_number")
    @Basic(optional = false)
    private String documentNumber;

    @Column(name = "changed_password")
    @Basic(optional = false)
    private Boolean changedPassword = false;

    @Column(name = "cms_password")
    @Basic(optional = false)
    private String cmsPassword;

    @Column(name = "email")
    @Basic(optional = false)
    private String email;

    @Column(name = "enabled")
    @Basic(optional = false)
    private Boolean enabled = true;

    @JoinTable(
            name = "tt_user_company",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="company_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MtCompany> companyList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<TtUserRole> userRoleList;

    public MtUser() {
    }

    public MtUser(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public Boolean getChangedPassword() {
        return changedPassword;
    }

    public void setChangedPassword(Boolean changedPassword) {
        this.changedPassword = changedPassword;
    }

    public String getCmsPassword() {
        return cmsPassword;
    }

    public void setCmsPassword(String cmsPassword) {
        this.cmsPassword = cmsPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<MtCompany> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<MtCompany> companyList) {
        this.companyList = companyList;
    }

    public List<TtUserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<TtUserRole> ttUserRoleList) {
        this.userRoleList = ttUserRoleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MtUser)) {
            return false;
        }
        MtUser other = (MtUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.canvia.smartview.core.entity.MtUser[ userId=" + userId + " ]";
    }
    
}
