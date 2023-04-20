package com.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

@Entity
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "country_id")
	private country country;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "city_id")
	private city city;
	
	private String first_name;
	private String last_name;
	
	@Column(unique = true)
	private String email;
	private String phone_number;
	private String password;
	private String avatar;
	private String why_i_volunteer;
	private int employee_id;
	private String department;
	private String profile_text;
	private String linked_in_url;
	private String title;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<favourite_mission> favourite_missions;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserSkill> userSkills;
	public enum Status{
		ACTIVE,
		INACTIVE
	}
	
	public user() {
		super();
	}
	
	public user(int user_id, com.entities.country country, com.entities.city city, String first_name, String last_name,
			String email, String phone_number, String password, String avatar, String why_i_volunteer, int employee_id,
			String department, String profile_text, String linked_in_url, String title, Status status, Date created_at,
			Date updated_at, Date deleted_at) {
		super();
		this.user_id = user_id;
		this.country = country;
		this.city = city;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.password = password;
		this.avatar = avatar;
		this.why_i_volunteer = why_i_volunteer;
		this.employee_id = employee_id;
		this.department = department;
		this.profile_text = profile_text;
		this.linked_in_url = linked_in_url;
		this.title = title;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public country getCountry() {
		return country;
	}

	public void setCountry(country country) {
		this.country = country;
	}

	public city getCity() {
		return city;
	}

	public void setCity(city city) {
		this.city = city;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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

	public String getWhy_i_volunteer() {
		return why_i_volunteer;
	}

	public void setWhy_i_volunteer(String why_i_volunteer) {
		this.why_i_volunteer = why_i_volunteer;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int i) {
		this.employee_id = i;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProfile_text() {
		return profile_text;
	}

	public void setProfile_text(String profile_text) {
		this.profile_text = profile_text;
	}

	public String getLinked_in_url() {
		return linked_in_url;
	}

	public void setLinked_in_url(String linked_in_url) {
		this.linked_in_url = linked_in_url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = new Date();
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

	@Override
	public String toString() {
		return "user [user_id=" + user_id + ", country=" + country + ", city=" + city + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", phone_number=" + phone_number + ", password="
				+ password + ", avatar=" + avatar + ", why_i_volunteer=" + why_i_volunteer + ", employee_id="
				+ employee_id + ", department=" + department + ", profile_text=" + profile_text + ", linked_in_url="
				+ linked_in_url + ", title=" + title + ", status=" + status + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
	}

	
	
}
