package com.dto;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.entities.skill;

public class EditProfileObject {
	private String name;
	private String surname;
	private int employeeId;
	private String manager;
	private String title;
	private String whyIVolunteer;
	private String department;
	private String myComments;
	private String city;
	private String country;
	@Enumerated(EnumType.STRING)
	private availability availability;
	public enum availability{
		WEEKLY,
		DAILY,
		MONTHLY
	}
	private String linkedInUrl;
	private List<skill> skills;
	public EditProfileObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EditProfileObject(String name, String surname, int employeeId, String manager, String title,
			String whyIVolunteer, String department, String myComments, String city, String country,
			com.dto.EditProfileObject.availability availability, String linkedInUrl, List<skill> skills) {
		super();
		this.name = name;
		this.surname = surname;
		this.employeeId = employeeId;
		this.manager = manager;
		this.title = title;
		this.whyIVolunteer = whyIVolunteer;
		this.department = department;
		this.myComments = myComments;
		this.city = city;
		this.country = country;
		this.availability = availability;
		this.linkedInUrl = linkedInUrl;
		this.skills = skills;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWhyIVolunteer() {
		return whyIVolunteer;
	}
	public void setWhyIVolunteer(String whyIVolunteer) {
		this.whyIVolunteer = whyIVolunteer;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMyComments() {
		return myComments;
	}
	public void setMyComments(String myComments) {
		this.myComments = myComments;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public availability getAvailability() {
		return availability;
	}
	public void setAvailability(availability availability) {
		this.availability = availability;
	}
	public String getLinkedInUrl() {
		return linkedInUrl;
	}
	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}
	public List<skill> getSkills() {
		return skills;
	}
	public void setSkills(List<skill> skills) {
		this.skills = skills;
	}
	
}
