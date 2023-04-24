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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mission_skill")
public class MissionSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_skill_id;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "skill_id")
	private Skill skill;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	public MissionSkill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionSkill(int mission_skill_id, com.entities.Skill skill, com.entities.Mission mission, Date created_at,
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
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
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
	@Override
	public String toString() {
		return "mission_skill [mission_skill_id=" + mission_skill_id + ", skill=" + skill + ", mission=" + mission
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
	}

	
	
	
}
