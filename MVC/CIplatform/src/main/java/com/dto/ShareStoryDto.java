package com.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ShareStoryDto {
	public int chekedMission;
	public int user_id;
	public String title;
	public Date date;
	public String description;
	public String videoUrl;
	public CommonsMultipartFile[] files;
	@Enumerated(EnumType.STRING)
	public status status;
	public enum status{
		PENDING,
		DRAFT,
		PUBLISHED,
		DELINED
	}
	public ShareStoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShareStoryDto(int chekedMission, int user_id, String title, Date date, String description, String videoUrl,
			CommonsMultipartFile[] files, com.dto.ShareStoryDto.status status) {
		super();
		this.chekedMission = chekedMission;
		this.user_id = user_id;
		this.title = title;
		this.date = date;
		this.description = description;
		this.videoUrl = videoUrl;
		this.files = files;
		this.status = status;
	}
	public int getChekedMission() {
		return chekedMission;
	}
	public void setChekedMission(int chekedMission) {
		this.chekedMission = chekedMission;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public CommonsMultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(CommonsMultipartFile[] files) {
		this.files = files;
	}
	public status getStatus() {
		return status;
	}
	public void setStatus(status status) {
		this.status = status;
	}

	
}
