package com.hk.prj.vite.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)		
@Entity
@Table(name="user_roles")
public class UserRole extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -66079422579360439L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)    
	@Column(name="user_role_id")
	private Long userroleid;

	@Column(name="userid")
	private Long userid;

	@Column(name="role")
	private String role; 


}
