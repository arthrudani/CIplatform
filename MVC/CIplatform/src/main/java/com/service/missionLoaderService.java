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
import com.entities.country;
import com.entities.favourite_mission;
import com.entities.mission;
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

	public String loadRelatedMissions(String CMCT, String CMCR, String CMT) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<mission> missions=this.missionLoaderInterface.loadrelatedmission(CMCT,CMCR,CMT);
		try {
			output=obj.writeValueAsString(missions);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
}
