package com.dao;


import java.util.List;
import com.dto.Filters;
import com.entities.city;
import com.entities.country;
import com.entities.mission;
import com.entities.mission_skill;
import com.entities.mission_theme;
import com.entities.skill;

public interface MissionLoaderInterface {
	public List<mission> loadAllMissionOnSearch(Filters filters);
	public List<country> loadListOfCountry();
	public List<city> loadCityOfCountry(int country_id);
	public List<mission_theme> loadAllThemes();
	public List<mission> loadAllMission();
	public List<skill> loadAllSkillOnSearch();
}
