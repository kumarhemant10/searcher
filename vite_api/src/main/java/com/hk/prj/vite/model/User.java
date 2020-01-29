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
@Table(name = "users")
public class User extends BaseEntity implements Serializable {

	public User(User user) {
		super();
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.setActive(user.isActive());
	}

	public User() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2968398317696218024L;
	

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)    
	 @Column(name="userid")
	 private Long userId;
	 
	 @Column(name = "username")
	 private String userName;   
	 
	 @Column(name = "password")
	 private String password;   
	 
	 @Column(name = "email")
	 private String email;
	 
	
	 
	

}
