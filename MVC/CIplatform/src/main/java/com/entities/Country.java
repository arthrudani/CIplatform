package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int country_id;
	private String name;
	private String ISO;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	public Country() {
		super();
	}
	public Country(int country_id, String name, String iSO, Date created_at, Date updated_at, Date deleted_at) {
		this.country_id = country_id;
		this.name = name;
		ISO = iSO;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getISO() {
		return ISO;
	}
	public void setISO(String iSO) {
		ISO = iSO;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = new Date();
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Date getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}
	@Override
	public String toString() {
		return "country [country_id=" + country_id + ", name=" + name + ", ISO=" + ISO + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
	}
	
	
}
