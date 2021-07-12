package com.cg.onlineshoppingapps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@NotNull(message = "User Name Is Mandatory!!")
	@Column(name = "username")
	private String username;

	@NotNull(message = "Password Is Mandatory!!")
	@Column(name = "password")
	private String password;

//	@NotNull(message = "Role Should Be Mentioned!!")
	@Column(name = "role")
	private String role;

	public UserEntity() {
		super();
	}

	public UserEntity( String username,String password,String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public UserEntity(String string) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

}
