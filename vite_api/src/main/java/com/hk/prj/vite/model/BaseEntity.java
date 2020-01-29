package com.hk.prj.vite.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 * class with common and auditable fields
 * @author hemant
 *
 */
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	 
	@Column(name ="active")
	private boolean active;
	
	@LastModifiedBy
	@Column(name="last_modified_by")
	private String lastModifiedBy;

	@CreatedBy
	@Column(name="created_by")
	private String createdBy;

	@LastModifiedDate
	@Column(name="last_modified_datetime")
	private LocalDateTime lastModifiedDateTime;

	@CreatedDate
	@Column(name="created_datetime")
	private LocalDateTime createdDateTime;
	
}
