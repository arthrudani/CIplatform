package com.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int comment_id;
	
	private String comment;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE,targetEntity = mission.class)
	@JoinColumn(name = "mission_id")
	private mission mission;
	
	@ManyToOne(cascade=CascadeType.MERGE,targetEntity = user.class)
	@JoinColumn(name = "user_id")
	private user user;
	
	@Enumerated(EnumType.ORDINAL)
	private AppStatus approval_status;
	
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	
	public enum AppStatus{
		ZERO,
		ONE,
		TWO
	}

	public comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public comment(int comment_id, String comment, com.entities.mission mission, com.entities.user user,
			AppStatus approval_status, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.comment_id = comment_id;
		this.comment = comment;
		this.mission = mission;
		this.user = user;
		this.approval_status = approval_status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public mission getMission() {
		return mission;
	}

	public void setMission(mission mission) {
		this.mission = mission;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public AppStatus getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(AppStatus approval_status) {
		this.approval_status = approval_status;
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
