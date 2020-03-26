package com.canvia.smartview.core.entity;

import com.canvia.smartview.core.entity.base.Audit;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tt_user_role")
@NamedQueries({
    @NamedQuery(name = "TtUserRole.findAll", query = "SELECT d FROM TtUserRole d")})
public class TtUserRole extends Audit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="TTUSERROLE_USERROLEID_GENERATOR", sequenceName="SQ_USER_ROLE", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TTUSERROLE_USERROLEID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "user_role_id")
    private Long userRoleId;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private MtUser user;

    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name = "role_code", referencedColumnName = "code", insertable = false, updatable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(value = "'ROLES'", referencedColumnName = "parent_group"))
    })
    @ManyToOne(fetch = FetchType.LAZY)
    private MtParameter role;

    public TtUserRole() {
    }

    public TtUserRole(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public MtUser getUser() {
        return user;
    }

    public void setUser(MtUser user) {
        this.user = user;
    }

    public MtParameter getRole() {
        return role;
    }

    public void setRole(MtParameter role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRoleId != null ? userRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TtUserRole)) {
            return false;
        }
        TtUserRole other = (TtUserRole) object;
        if ((this.userRoleId == null && other.userRoleId != null) || (this.userRoleId != null && !this.userRoleId.equals(other.userRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.canvia.smartview.core.entity.TtUserRole[ userRoleId=" + userRoleId + " ]";
    }
    
}
