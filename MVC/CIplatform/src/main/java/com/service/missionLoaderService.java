package com.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MissionLoaderInterface;
import com.dto.Filters;
import com.entities.city;
import com.entities.country;
import com.entities.mission;
import com.entities.mission_skill;
import com.entities.mission_theme;
import com.entities.skill;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class missionLoaderService implements missionLoader {

	@Autowired
	MissionLoaderInterface missionLoaderInterface;
	
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
	
	public List<mission> loadAllMissionOnSearch(Filters filters) {
		return this.missionLoaderInterface.loadAllMissionOnSearch(filters);
	}


	
}
