package com.canvia.smartview.core.entity;

import com.canvia.smartview.core.entity.base.Audit;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mt_parameter")
@NamedQueries({
    @NamedQuery(name = "MtParameter.findAll", query = "SELECT d FROM MtParameter d")})
public class MtParameter extends Audit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="MTPARAMETER_PARAMETERID_GENERATOR", sequenceName="SQ_PARAMETER", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MTPARAMETER_PARAMETERID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "parameter_id")
    private Long parameterId;

    @Column(name = "parent_group")
    @Basic(optional = false)
    private String parent_group;

    @Column(name = "code")
    @Basic(optional = false)
    private String code;

    @Column(name = "value")
    @Basic(optional = false)
    private String value;

    @Column(name = "description")
    private String description;

    @Column(name = "sort")
    @Basic(optional = false)
    private Integer sort;

    public MtParameter() {
    }

    public MtParameter(Long parameterId) {
        this.parameterId = parameterId;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public String getParent_group() {
        return parent_group;
    }

    public void setParent_group(String parent_group) {
        this.parent_group = parent_group;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parameterId != null ? parameterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MtParameter)) {
            return false;
        }
        MtParameter other = (MtParameter) object;
        if ((this.parameterId == null && other.parameterId != null) || (this.parameterId != null && !this.parameterId.equals(other.parameterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.canvia.smartview.core.entity.MtParameter[ parameterId=" + parameterId + " ]";
    }
    
}
