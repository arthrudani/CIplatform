package com.CIplatform.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.entities.City;
import com.entities.Country;
import com.entities.User.Status;

public class AddNewUserDto {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String avatar;
	private int employeeId;
	private String department;
	private String country;
	private String city;
	private String profileText;
	private Status status;
	public AddNewUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddNewUserDto(String firstName, String lastName, String email, String password, String avatar,
			int employeeId, String department, String country, String city, String profileText, Status status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
		this.employeeId = employeeId;
		this.department = department;
		this.country = country;
		this.city = city;
		this.profileText = profileText;
		this.status = status;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProfileText() {
		return profileText;
	}
	public void setProfileText(String profileText) {
		this.profileText = profileText;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
