package com.entities;

import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "mission_media")
public class MissionMedia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mission_media_id")
	private int missionMediaId;
	@JsonIgnore
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;

	private String name;
	private String type;
	private String path;
	@Enumerated(EnumType.ORDINAL)
	private defaultype defaultype;
	public enum defaultype{
		ZERO,
		ONE
	}
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public MissionMedia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionMedia(int missionMediaId, Mission mission, String name, String type, String path,
			com.entities.MissionMedia.defaultype defaultype, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.missionMediaId = missionMediaId;
		this.mission = mission;
		this.name = name;
		this.type = type;
		this.path = path;
		this.defaultype = defaultype;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getMissionMediaId() {
		return missionMediaId;
	}
	public void setMissionMediaId(int missionMediaId) {
		this.missionMediaId = missionMediaId;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public defaultype getDefaultype() {
		return defaultype;
	}
	public void setDefaultype(defaultype defaultype) {
		this.defaultype = defaultype;
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
