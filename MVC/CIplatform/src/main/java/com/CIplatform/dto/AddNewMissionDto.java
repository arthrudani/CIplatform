package com.CIplatform.dto;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.entities.Mission.Status;
import com.entities.Mission.availability;
import com.entities.Mission.mission_type;

public class AddNewMissionDto {
	private int missionId;
	private String title;
	private String shortDescription;
	private String description;
	private int country;
	private int city;
	private String organizationName;
	private String organizationDetail;
	private Date startDate;
	private Date endDate;
	private mission_type type;
	private int totalSeats;
	private Date registrationDeadline;
	private int goalValue;
	private String goalObjective;
	private int themeId;
	private int skill[];
	public CommonsMultipartFile[] images;
	public CommonsMultipartFile[] documents;
	private availability availability;
	private Status status;
	private String videoUrl;
	public AddNewMissionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AddNewMissionDto(int missionId, String title, String shortDescription, String description, int country,
			int city, String organizationName, String organizationDetail, Date startDate, Date endDate,
			mission_type type, int totalSeats, Date registrationDeadline, int themeId, int[] skill,
			CommonsMultipartFile[] images, CommonsMultipartFile[] documents,
			com.entities.Mission.availability availability, Status status, String videoUrl) {
		super();
		this.missionId = missionId;
		this.title = title;
		this.shortDescription = shortDescription;
		this.description = description;
		this.country = country;
		this.city = city;
		this.organizationName = organizationName;
		this.organizationDetail = organizationDetail;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.totalSeats = totalSeats;
		this.registrationDeadline = registrationDeadline;
		this.themeId = themeId;
		this.skill = skill;
		this.images = images;
		this.documents = documents;
		this.availability = availability;
		this.status = status;
		this.videoUrl = videoUrl;
	}
	
	public int getGoalValue() {
		return goalValue;
	}


	public void setGoalValue(int goalValue) {
		this.goalValue = goalValue;
	}


	public String getGoalObjective() {
		return goalObjective;
	}


	public void setGoalObjective(String goalObjective) {
		this.goalObjective = goalObjective;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationDetail() {
		return organizationDetail;
	}
	public void setOrganizationDetail(String organizationDetail) {
		this.organizationDetail = organizationDetail;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public mission_type getType() {
		return type;
	}
	public void setType(mission_type type) {
		this.type = type;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public Date getRegistrationDeadline() {
		return registrationDeadline;
	}
	public void setRegistrationDeadline(Date registrationDeadline) {
		this.registrationDeadline = registrationDeadline;
	}
	public int getThemeId() {
		return themeId;
	}
	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}
	public int[] getSkill() {
		return skill;
	}
	public void setSkill(int[] skill) {
		this.skill = skill;
	}
	public CommonsMultipartFile[] getImages() {
		return images;
	}
	public void setImages(CommonsMultipartFile[] images) {
		this.images = images;
	}
	public CommonsMultipartFile[] getDocuments() {
		return documents;
	}
	public void setDocuments(CommonsMultipartFile[] documents) {
		this.documents = documents;
	}
	public availability getAvailability() {
		return availability;
	}
	public void setAvailability(availability availability) {
		this.availability = availability;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
}
