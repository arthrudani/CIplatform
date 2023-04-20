package com.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class story {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int story_id;
	
	@ManyToOne(cascade=CascadeType.MERGE,targetEntity = user.class)
	@JoinColumn(name = "user_id")
	private user user;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE,targetEntity = mission.class)
	@JoinColumn(name = "mission_id")
	private mission mission;
	
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	private status status;
	public enum status{
		PENDING,
		DRAFT,
		PUBLISHED,
		DELINED
	}
	
	private Date published_at;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	
	@OneToMany(mappedBy = "story", cascade = CascadeType.ALL)
	private List<StoryMedia> medias;
	
	public story() {
		super();
		// TODO Auto-generated constructor stub
	}

	public story(int story_id, com.entities.user user, com.entities.mission mission, String title, String description,
			com.entities.story.status status, Date published_at, Date created_at, Date updated_at, Date deleted_at,
			List<StoryMedia> medias) {
		super();
		this.story_id = story_id;
		this.user = user;
		this.mission = mission;
		this.title = title;
		this.description = description;
		this.status = status;
		this.published_at = published_at;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.medias = medias;
	}

	public int getStory_id() {
		return story_id;
	}

	public void setStory_id(int story_id) {
		this.story_id = story_id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public status getStatus() {
		return status;
	}

	public void setStatus(status status) {
		this.status = status;
	}

	public Date getPublished_at() {
		return published_at;
	}

	public void setPublished_at(Date published_at) {
		this.published_at = published_at;
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

	public List<StoryMedia> getMedias() {
		return medias;
	}

	public void setMedias(List<StoryMedia> medias) {
		this.medias = medias;
	}
	
}
