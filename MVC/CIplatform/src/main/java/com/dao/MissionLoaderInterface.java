package com.dao;


import java.util.List;

import com.dto.Filters;
import com.entities.city;
import com.entities.country;
import com.entities.favourite_mission;
import com.entities.mission;
import com.entities.mission_skill;
import com.entities.mission_theme;
import com.entities.skill;
import com.entities.user;

public interface MissionLoaderInterface {
	public List<mission> loadAllMissionOnSearch(Filters filters);
	public List<country> loadListOfCountry();
	public List<city> loadCityOfCountry(int country_id);
	public List<mission_theme> loadAllThemes();
	public List<mission> loadAllMission();
	public List<skill> loadAllSkillOnSearch();
	public Long countAllMission(Filters filters);
	public void save(favourite_mission fv);
	public void delete(favourite_mission favourite_mission1);
	public List<mission> loadrelatedmission(mission mission, city city, country country, mission_theme mission_theme);
	public List<mission> getLikedMission(user user);
	public List<user> loadAllUserOnSearch();
}
