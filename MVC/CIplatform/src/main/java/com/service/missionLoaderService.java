package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.dao.MissionLoaderInterface;
import com.dto.AddToFavourite;
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

	@Transactional
	public String addtofav(AddToFavourite addToFavourite) {
		System.out.println("ATF object:"+addToFavourite);
		favourite_mission fv=new favourite_mission();
		user a=addToFavourite.getUser_id();
		mission m=addToFavourite.getMission_id();
		fv.setUser(a);
		fv.setMission(m);
		System.out.println("FM object:"+fv);
		this.missionLoaderInterface.save(fv);
		return "true";
	}


	
}
