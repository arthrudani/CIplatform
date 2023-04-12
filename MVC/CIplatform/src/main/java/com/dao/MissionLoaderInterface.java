package com.dao;


import java.util.List;

import com.dto.Filters;
import com.entities.city;
import com.entities.comment;
import com.entities.country;
import com.entities.favourite_mission;
import com.entities.mission;
import com.entities.mission_application;
import com.entities.mission_document;
import com.entities.mission_rating;
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
	public int getRatingCount(mission mission);
	public Double getAverageRatings(mission mission);
	public void save(mission_rating mission_rating1);
	public void saveorupdate(mission_rating mission_rating1);
	public void delete(mission_rating mission_rating1);
	public List<comment> getAllComments(mission mission);
	public List<mission_document> loadAllDocuments(mission mission);
	public List<mission_skill> loadMissionSkills(mission mission);
	public List<mission_application> loadRecentVolunteers(mission mission, int currentPage);
	public int loadTotalRecentVolunteers(mission mission);
}
