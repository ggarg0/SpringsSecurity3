package com.springs.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "USERS")
public class Users {

	private Integer userid;
	private String username;
	private String password;
	private Integer enabled;
	private Set<UserRoles> userRole = new HashSet<UserRoles>(0);

	public Users() {
	}

	public Users(int userid, String username, String password, int enabled) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public Users(int userid, String username, String password, int enabled, Set<UserRoles> userRole) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}
	
	@Id
	@Column(name = "userid")
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled")
	public int isEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "USERS")
	public Set<UserRoles> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRoles> userRole) {
		this.userRole = userRole;
	}

}
