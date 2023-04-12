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
public class mission_invite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_invite_id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE,targetEntity = mission.class)
	@JoinColumn(name = "mission_id")
	private mission mission;
	
	@ManyToOne(cascade=CascadeType.MERGE,targetEntity = user.class)
	@JoinColumn(name = "from_user_id")
	private user from_user;
	
	@ManyToOne(cascade=CascadeType.MERGE,targetEntity = user.class)
	@JoinColumn(name = "to_user_id")
	private user to_user;
	
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	
	public mission_invite() {
		super();
	}
	
	public mission_invite(int mission_invite_id, com.entities.mission mission, user from_user, user to_user,
			Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.mission_invite_id = mission_invite_id;
		this.mission = mission;
		this.from_user = from_user;
		this.to_user = to_user;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public int getMission_invite_id() {
		return mission_invite_id;
	}
	public void setMission_invite_id(int mission_invite_id) {
		this.mission_invite_id = mission_invite_id;
	}
	public mission getMission() {
		return mission;
	}
	public void setMission(mission mission) {
		this.mission = mission;
	}
	public user getFrom_user() {
		return from_user;
	}
	public void setFrom_user(user from_user) {
		this.from_user = from_user;
	}
	public user getTo_user() {
		return to_user;
	}
	public void setTo_user(user to_user) {
		this.to_user = to_user;
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
	
	
}
