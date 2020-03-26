package com.canvia.smartview.core.entity.base;

import com.canvia.smartview.core.security.SmartViewAuthentication;
import com.canvia.smartview.core.util.ConstantsCore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

//@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class Audit {

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @PrePersist
    public void prePersist() {
    	if(this.createdBy==null) {
	    	SmartViewAuthentication authentication = (SmartViewAuthentication) SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null || !authentication.isAuthenticated()) {
				this.createdBy = ConstantsCore.APPLICATION_NAME;
			} else {
				this.createdBy = authentication.getUserDto().getUsername();
			}
		}
    	this.createdDate = new Date();
    }
    @PreUpdate
    public void PreUpdate() {
    	if(this.lastModifiedBy==null) {
            SmartViewAuthentication authentication = (SmartViewAuthentication) SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null || !authentication.isAuthenticated()) {
				this.lastModifiedBy = ConstantsCore.APPLICATION_NAME;
			} else {
				this.lastModifiedBy = authentication.getUserDto().getUsername();
			}
    	}
    	this.lastModifiedDate = new Date();
    }

}
