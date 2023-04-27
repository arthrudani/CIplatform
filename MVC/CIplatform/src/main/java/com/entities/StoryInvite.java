package com.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "story_invite")
public class StoryInvite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "story_invite_id")
	private int storyInviteId;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE,targetEntity = Story.class)
	@JoinColumn(name = "story_id")
	private Story story;
	
	@ManyToOne(cascade=CascadeType.MERGE,targetEntity = User.class)
	@JoinColumn(name = "from_user_id")
	private User fromUser;
	
	@ManyToOne(cascade=CascadeType.MERGE,targetEntity = User.class)
	@JoinColumn(name = "to_user_id")
	private User toUser;
	
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public StoryInvite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoryInvite(int storyInviteId, Story story, User fromUser, User to_user, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super();
		this.storyInviteId = storyInviteId;
		this.story = story;
		this.fromUser = fromUser;
		this.toUser = to_user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getStoryInviteId() {
		return storyInviteId;
	}
	public void setStoryInviteId(int storyInviteId) {
		this.storyInviteId = storyInviteId;
	}
	public Story getStory() {
		return story;
	}
	public void setStory(Story story) {
		this.story = story;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getTo_user() {
		return toUser;
	}
	public void setTo_user(User to_user) {
		this.toUser = to_user;
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
