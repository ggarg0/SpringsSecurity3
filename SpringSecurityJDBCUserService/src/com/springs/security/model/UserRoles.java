package com.springs.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "USER_ROLES")
public class UserRoles{

	private Integer userId;
	private String rolename;

	public UserRoles() {
	}

	public UserRoles(int userId, String rolename) {
		this.userId = userId;
		this.rolename = rolename;
	}

	@Id
	@Column(name = "userid")
	public Integer getUserRoleId() {
		return this.userId;
	}

	public void setUserRoleId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "rolename")
	public String getRoleName() {
		return this.rolename;
	}

	public void setRoleName(String rolename) {
		this.rolename = rolename;
	}

}