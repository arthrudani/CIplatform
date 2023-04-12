package com.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.dao.MissionLoaderInterface;
import com.dto.Filters;
import com.entities.city;
import com.entities.comment;
import com.entities.country;
import com.entities.favourite_mission;
import com.entities.mission;
import com.entities.mission_application;
import com.entities.mission_application.approval;
import com.entities.mission_document;
import com.entities.mission_invite;
import com.entities.mission_rating;
import com.entities.mission_skill;
import com.entities.mission_theme;
import com.entities.skill;
import com.entities.user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class missionLoaderService implements missionLoader {

	@Autowired
	MissionLoaderInterface missionLoaderInterface;
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public List<mission> loadAllMission() {
		return this.missionLoaderInterface.loadAllMission();
	}

	public List<country> loadListOfCountry() {
		return missionLoaderInterface.loadListOfCountry();
	}

	public List<city> loadCityOfCountry(int country_id) {
		return this.missionLoaderInterface.loadCityOfCountry(country_id);
	}

	public List<mission_theme> loadAllThemes() {
		return this.missionLoaderInterface.loadAllThemes();
	}
	
	public List<skill> loadAllSkill() {
		return this.missionLoaderInterface.loadAllSkillOnSearch();
	}
	
	public List<user> loadAllUsers() {
		return this.missionLoaderInterface.loadAllUserOnSearch();
	}
	
	public String loadAllMissionOnSearch(Filters filters) {
		Map<Long, List<mission>> map=new HashMap<Long,List<mission>>();
		String output="";
		ObjectMapper obj=new ObjectMapper();
		Long totalmission=this.missionLoaderInterface.countAllMission(filters);
		List<mission> missions=this.missionLoaderInterface.loadAllMissionOnSearch(filters);
		map.put(totalmission, missions);
		try {
			output=obj.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return output;
	}
	

	public mission getMissionById(int missionId) {
		return this.hibernateTemplate.get(mission.class, missionId);
	}


	public user getUserById(int userId) {
		return this.hibernateTemplate.get(user.class, userId);
	}

	public String addToFavourite(int mID, int uID) {
		mission mission=this.hibernateTemplate.get(mission.class, mID);
		user user=this.hibernateTemplate.get(user.class, uID);
		
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from favourite_mission where mission_id=:mission_id and user_id=:user_id");
		query.setParameter("mission_id", mID);
		query.setParameter("user_id", uID);
		favourite_mission favourite_mission1 = (favourite_mission) query.uniqueResult();
		
		if(favourite_mission1==null) {
			favourite_mission favourite_mission=new favourite_mission();
			favourite_mission.setCreated_at(new Date());
			favourite_mission.setMission(mission);
			favourite_mission.setUser(user);
			
			this.missionLoaderInterface.save(favourite_mission);
			return "true";
		}
		else {
			this.missionLoaderInterface.delete(favourite_mission1);
			return "false";
		}
	}

	public city getCityForRelated(String CMCT) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from city where name=:name");
		query.setParameter("name", CMCT);
		city city=(com.entities.city) query.uniqueResult();
		return city;
	}

	public country getCountryForRelated(String CMCR) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from country where name=:name");
		query.setParameter("name", CMCR);
		country country=(com.entities.country) query.uniqueResult();
		return country;
	}

	public mission_theme getThemeForRelated(String CMT) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from mission_theme where title=:title");
		query.setParameter("title", CMT);
		mission_theme mission_theme=(com.entities.mission_theme) query.uniqueResult();
		return mission_theme;
	}

	public String loadRelatedMissions(mission mission,city city, country country, mission_theme mission_theme) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<mission> missions=this.missionLoaderInterface.loadrelatedmission(mission,city,country,mission_theme);
		if(missions.size()>3) {
			missions=missions.subList(0, 3);
		}
		try {
			output=obj.writeValueAsString(missions);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}

	public List<mission> loadLikedMission(user user) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<mission> liked=this.missionLoaderInterface.getLikedMission(user);
		return liked;
	}

	public Double getRatings(mission mission) {
		
		Double sum=this.missionLoaderInterface.getAverageRatings(mission);
//		int totalRatedBy=this.missionLoaderInterface.getRatingCount(mission);
		return sum;
		
	}

	public String rateMission(int mID, int uID, int ratings) {
		mission mission=this.hibernateTemplate.get(mission.class, mID);
		user user=this.hibernateTemplate.get(user.class, uID);
		
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from mission_rating where mission_id=:mission_id and user_id=:user_id");
		query.setParameter("mission_id", mID);
		query.setParameter("user_id", uID);
		mission_rating mission_rating=(mission_rating) query.uniqueResult();
		
		if(mission_rating!=null) {
			this.missionLoaderInterface.delete(mission_rating);
		}
		else {
			
		}
		mission_rating mission_rating1=new mission_rating();
		mission_rating1.setCreated_at(new Date());
		mission_rating1.setMission(mission);
		mission_rating1.setUser(user);
		mission_rating1.setRating(ratings);
		this.missionLoaderInterface.save(mission_rating1);
		return "true";
	}

	public int getRatingsOfCurrent(int mID, int uID) {
		mission mission=this.hibernateTemplate.get(mission.class, mID);
		user user=this.hibernateTemplate.get(user.class, uID);
		
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from mission_rating where mission_id=:mission_id and user_id=:user_id");
		query.setParameter("mission_id", mission.getMission_id());
		query.setParameter("user_id", user.getUser_id());
		mission_rating mission_rating=(mission_rating) query.uniqueResult();
		if(mission_rating != null) {
			return mission_rating.getRating();
		}
		return 0;
	}

	@Transactional
	public String recommendToCoWorker(mission mission,String email,user user) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from user where email=:email");
		query.setParameter("email", email);
		user touser=(com.entities.user) query.uniqueResult();
		
		mission_invite mission_invite=new mission_invite();
		mission_invite.setCreated_at(new Date());
		mission_invite.setMission(mission);;
		mission_invite.setTo_user(touser);
		mission_invite.setFrom_user(user);
		this.hibernateTemplate.save(mission_invite);
		
		SendMailSSL.send("arthrudanitatvasoft@gmail.com", "unydsjatgfbcbawb", email, "You are recommended to ","http://localhost:8080/CIplatform/VolunteeringMission?mid="+mission.getMission_id()+"&uid="+user.getUser_id());
		return null;
	}

	@Transactional
	public String addComment(mission mission, String comments, user user) {
		comment comment=new comment();
		comment.setCreated_at(new Date());
		comment.setMission(mission);
		comment.setUser(user);
		comment.setComment(comments);
		this.hibernateTemplate.save(comment);
		return null;
	}

	public String loadAllComment(mission mission) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<comment> comments=this.missionLoaderInterface.getAllComments(mission);
		try {
			output=obj.writeValueAsString(comments);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	public String loadAllDocuments(mission mission) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<mission_document> comments=this.missionLoaderInterface.loadAllDocuments(mission);
		try {
			output=obj.writeValueAsString(comments);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	public String loadMissionSkills(mission mission) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<mission_skill> comments=this.missionLoaderInterface.loadMissionSkills(mission);
		try {
			output=obj.writeValueAsString(comments);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	@Transactional
	public void applyForMission(mission mission,user user) {
		mission_application application=new mission_application();
		application.setApplied_at(new Date());
		application.setMission(mission);
		application.setUser(user);
		application.setApproval_status(approval.TWO);
		this.hibernateTemplate.save(application);
	}
	
	public approval appliedOrNotForMission(mission mission,user user) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from mission_application where mission_id=:mission_id and user_id=:user_id");
		query.setParameter("mission_id", mission.getMission_id());
		query.setParameter("user_id", user.getUser_id());
		if(query.list().size()==1) {
			mission_application application=(mission_application) query.uniqueResult();
			return application.getApproval_status();
		}
		return approval.ZERO;
	}

	public String loadRecentVolunteers(mission mission,int currentPage) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<mission_application> users=this.missionLoaderInterface.loadRecentVolunteers(mission,currentPage);
		try {
			output=obj.writeValueAsString(users);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	public int loadTotalRecentVolunteers(mission mission) {
		return this.missionLoaderInterface.loadTotalRecentVolunteers(mission);
	}
}
