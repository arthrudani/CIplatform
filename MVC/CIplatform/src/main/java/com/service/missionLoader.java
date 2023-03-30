package com.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.Filters;
import com.entities.city;
import com.entities.country;
import com.entities.mission;
import com.entities.mission_skill;
import com.entities.mission_theme;
import com.entities.skill;
import com.entities.user;


@Service
public interface missionLoader {
	public String loadAllMissionOnSearch(Filters filters);
	public List<country> loadListOfCountry();
	public List<city> loadCityOfCountry(int country_id);
	public List<mission_theme> loadAllThemes();
	public List<mission> loadAllMission();
	public List<skill> loadAllSkill();
	public mission getMissionById(int missionId);
	public user getUserById(int userId);
	public String addToFavourite(int mID, int uID);
	public city getCityForRelated(String CMCT);
	public country getCountryForRelated(String CMCR);
	public mission_theme getThemeForRelated(String CMT);
	public String loadRelatedMissions(mission mission, city city, country country, mission_theme mission_theme);
	public List<mission> loadLikedMission(user user);
}
