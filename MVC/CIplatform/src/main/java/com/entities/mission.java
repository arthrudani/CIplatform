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
import javax.persistence.OneToOne;

import com.entities.mission.Status;

@Entity
public class mission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "theme_id")
	private mission_theme mission_theme;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "city_id")
	private city city;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "country_id")
	private country country;
	
	private String title;
	private String short_description;
	private String description;
	private Date start_date;
	private Date end_date;
	@Enumerated(EnumType.STRING)
	private mission_type mission_type;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String	organization_name;
	private String	organization_detail;
	@Enumerated(EnumType.STRING)
	private availability	availability;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	public enum Status{
		ACTIVE,
		INACTIVE
	}
	public enum mission_type{
		TIME,
		GOAL
	}
	public enum availability{
		WEEKLY,
		MONTHLY,
		DAILY
	}
	
	@OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
	private List<mission_skill> mission_skills;

	@OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
	private List<mission_rating> mission_ratings;

	@OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
	private List<mission_document> mission_documents;

	public mission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public mission(int mission_id, com.entities.mission_theme mission_theme, com.entities.city city,
			com.entities.country country, String title, String short_description, String description, Date start_date,
			Date end_date, com.entities.mission.mission_type mission_type, Status status, String organization_name,
			String organization_detail, com.entities.mission.availability availability, Date created_at,
			Date updated_at, Date deleted_at, List<mission_skill> mission_skills, List<mission_rating> mission_ratings,
			List<mission_document> mission_documents) {
		super();
		this.mission_id = mission_id;
		this.mission_theme = mission_theme;
		this.city = city;
		this.country = country;
		this.title = title;
		this.short_description = short_description;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.mission_type = mission_type;
		this.status = status;
		this.organization_name = organization_name;
		this.organization_detail = organization_detail;
		this.availability = availability;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.mission_skills = mission_skills;
		this.mission_ratings = mission_ratings;
		this.mission_documents = mission_documents;
	}

	public int getMission_id() {
		return mission_id;
	}

	public void setMission_id(int mission_id) {
		this.mission_id = mission_id;
	}

	public mission_theme getMission_theme() {
		return mission_theme;
	}

	public void setMission_theme(mission_theme mission_theme) {
		this.mission_theme = mission_theme;
	}

	public city getCity() {
		return city;
	}

	public void setCity(city city) {
		this.city = city;
	}

	public country getCountry() {
		return country;
	}

	public void setCountry(country country) {
		this.country = country;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public mission_type getMission_type() {
		return mission_type;
	}

	public void setMission_type(mission_type mission_type) {
		this.mission_type = mission_type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getOrganization_detail() {
		return organization_detail;
	}

	public void setOrganization_detail(String organization_detail) {
		this.organization_detail = organization_detail;
	}

	public availability getAvailability() {
		return availability;
	}

	public void setAvailability(availability availability) {
		this.availability = availability;
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

	public List<mission_skill> getMission_skills() {
		return mission_skills;
	}

	public void setMission_skills(List<mission_skill> mission_skills) {
		this.mission_skills = mission_skills;
	}

	public List<mission_rating> getMission_ratings() {
		return mission_ratings;
	}

	public void setMission_ratings(List<mission_rating> mission_ratings) {
		this.mission_ratings = mission_ratings;
	}

	public List<mission_document> getMission_documents() {
		return mission_documents;
	}

	public void setMission_documents(List<mission_document> mission_documents) {
		this.mission_documents = mission_documents;
	}
	
	
}
