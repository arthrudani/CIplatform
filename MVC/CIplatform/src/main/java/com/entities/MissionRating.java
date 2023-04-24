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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mission_rating")
public class MissionRating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_rating_id;
	

	@ManyToOne(cascade=CascadeType.MERGE,targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE,targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	
	private int rating;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	
	public MissionRating() {
		super();
	}

	public MissionRating(int mission_rating_id, com.entities.User user, com.entities.Mission mission, int rating,
			Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.mission_rating_id = mission_rating_id;
		this.user = user;
		this.mission = mission;
		this.rating = rating;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public int getMission_rating_id() {
		return mission_rating_id;
	}

	public void setMission_rating_id(int mission_rating_id) {
		this.mission_rating_id = mission_rating_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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
