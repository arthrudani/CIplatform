package com.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_skill")
public class UserSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_skill_id")
	private int userSkillId;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "skill_id")
	private skill skill;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private user user;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public UserSkill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSkill(int userSkillId, com.entities.skill skill, com.entities.user user, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super();
		this.userSkillId = userSkillId;
		this.skill = skill;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getUserSkillId() {
		return userSkillId;
	}
	public void setUserSkillId(int userSkillId) {
		this.userSkillId = userSkillId;
	}
	public skill getSkill() {
		return skill;
	}
	public void setSkill(skill skill) {
		this.skill = skill;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	
}
