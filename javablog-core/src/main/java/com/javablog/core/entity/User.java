package com.javablog.core.entity;

import java.sql.Timestamp;

public class User {

	private Integer id;
	
	private Timestamp registered;
	
	private Timestamp lastLogin;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Boolean enabled;
	
	public User() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getRegistered() {
		return registered;
	}

	public void setRegistered(Timestamp registered) {
		this.registered = registered;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
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

	@Override
	public String toString() {
		return "User [email=" + email + ", enabled=" + enabled + ", id=" + id
				+ ", lastLogin=" + lastLogin + ", password=" + password
				+ ", registered=" + registered + ", username=" + username + "]";
	}
	
	
}
