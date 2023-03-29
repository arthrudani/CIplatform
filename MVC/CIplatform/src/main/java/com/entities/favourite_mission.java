package com.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class favourite_mission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int favourite_mission_id;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private user user;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "mission_id")
	private mission mission;
	
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	public favourite_mission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public favourite_mission(int favourite_mission_id, com.entities.user user, com.entities.mission mission,
			Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.favourite_mission_id = favourite_mission_id;
		this.user = user;
		this.mission = mission;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getFavourite_mission_id() {
		return favourite_mission_id;
	}
	public void setFavourite_mission_id(int favourite_mission_id) {
		this.favourite_mission_id = favourite_mission_id;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public mission getMission() {
		return mission;
	}
	public void setMission(mission mission) {
		this.mission = mission;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
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
		return "favourite_mission [favourite_mission_id=" + favourite_mission_id + ", user=" + user + ", mission="
				+ mission + ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at=" + deleted_at
				+ "]";
	}
	

}
