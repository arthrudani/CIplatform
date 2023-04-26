package com.entities;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "timesheet")
public class Timesheet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "timesheet_id")
	private int timesheetId;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	private LocalTime time;
	private int action;
	@Column(name = "date_volunteered")
	private Date dateVolunteered;
	private String notes;
	@Enumerated(EnumType.STRING)
	private approval status;
	public enum approval{
		PENDING,
		PUBLISHED
	}
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public Timesheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Timesheet(int timesheetId, User user, Mission mission, LocalTime time, int action, Date dateVolunteered,
			String notes, approval status, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.timesheetId = timesheetId;
		this.user = user;
		this.mission = mission;
		this.time = time;
		this.action = action;
		this.dateVolunteered = dateVolunteered;
		this.notes = notes;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getTimesheetId() {
		return timesheetId;
	}
	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
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
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public Date getDateVolunteered() {
		return dateVolunteered;
	}
	public void setDateVolunteered(Date dateVolunteered) {
		this.dateVolunteered = dateVolunteered;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public approval getStatus() {
		return status;
	}
	public void setStatus(approval status) {
		this.status = status;
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
