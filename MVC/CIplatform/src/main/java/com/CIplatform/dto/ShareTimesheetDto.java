package com.CIplatform.dto;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ShareTimesheetDto {
	public int chekedMission;
	public int user_id;
	public Date date;
	public int hours;
	public int minutes;
	public String message;
	public int action;
	public int timesheetId;
	public ShareTimesheetDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShareTimesheetDto(int chekedMission, int user_id, Date date, int hours, int minutes, String message,
			int action, int timesheetId) {
		super();
		this.chekedMission = chekedMission;
		this.user_id = user_id;
		this.date = date;
		this.hours = hours;
		this.minutes = minutes;
		this.message = message;
		this.action = action;
		this.timesheetId = timesheetId;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public int getTimesheetId() {
		return timesheetId;
	}
	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}
	
}
