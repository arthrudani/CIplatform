package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class password_reset {
	
	private String token;
	@Id
	@Column(unique = true)
	private String email;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Date created_at;
	
	public password_reset() {
		super();
	}

	public password_reset(String token, String email, Date created_at) {
		super();
		this.token = token;
		this.email = email;
		this.created_at = created_at;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
}
