package com.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class mission_skill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_skill_id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "skill_id")
	private skill skill;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "mission_id")
	private mission mission;
	
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	public mission_skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mission_skill(int mission_skill_id, com.entities.skill skill, com.entities.mission mission, Date created_at,
			Date updated_at, Date deleted_at) {
		super();
		this.mission_skill_id = mission_skill_id;
		this.skill = skill;
		this.mission = mission;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getMission_skill_id() {
		return mission_skill_id;
	}
	public void setMission_skill_id(int mission_skill_id) {
		this.mission_skill_id = mission_skill_id;
	}
	public skill getSkill() {
		return skill;
	}
	public void setSkill(skill skill) {
		this.skill = skill;
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

	
	
	
}
