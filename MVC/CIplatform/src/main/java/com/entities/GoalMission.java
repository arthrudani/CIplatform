package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "goal_missin")
public class GoalMission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "goal_mission_id")
	private int goalMissionId;
	
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	@Column(name = "alreadyVolunteer")
	private int alreadyVolunteer;
	@Column(name = "goal_objective_text")
	private String goalObjectiveText;
	@Column(name = "goal_value")
	private int goalValue;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public GoalMission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoalMission(int goalMissionId, Mission mission, String goalObjectiveText, int goalValue, Date createdAt,
			Date updatedAt, Date deletedAt) {
		super();
		this.goalMissionId = goalMissionId;
		this.mission = mission;
		this.goalObjectiveText = goalObjectiveText;
		this.goalValue = goalValue;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public int getAlreadyVolunteer() {
		return alreadyVolunteer;
	}
	public void setAlreadyVolunteer(int alreadyVolunteer) {
		this.alreadyVolunteer = alreadyVolunteer;
	}
	public int getGoalMissionId() {
		return goalMissionId;
	}
	public void setGoalMissionId(int goalMissionId) {
		this.goalMissionId = goalMissionId;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public String getGoalObjectiveText() {
		return goalObjectiveText;
	}
	public void setGoalObjectiveText(String goalObjectiveText) {
		this.goalObjectiveText = goalObjectiveText;
	}
	public int getGoalValue() {
		return goalValue;
	}
	public void setGoalValue(int goalValue) {
		this.goalValue = goalValue;
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
