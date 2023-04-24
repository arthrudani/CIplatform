package com.dao;


import java.util.List;

import com.dto.Filters;
import com.entities.City;
import com.entities.Comment;
import com.entities.Country;
import com.entities.FavouriteMission;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.MissionDocument;
import com.entities.MissionRating;
import com.entities.MissionSkill;
import com.entities.MissionTheme;
import com.entities.Skill;
import com.entities.User;

public interface MissionLoaderInterface {
	public List<Mission> loadAllMissionOnSearch(Filters filters);
	public List<Country> loadListOfCountry();
	public List<City> loadCityOfCountry(int country_id);
	public List<MissionTheme> loadAllThemes();
	public List<Mission> loadAllMission();
	public List<Skill> loadAllSkillOnSearch();
	public Long countAllMission(Filters filters);
	public void save(FavouriteMission fv);
	public void delete(FavouriteMission favourite_mission1);
	public List<Mission> loadrelatedmission(Mission mission, City city, Country country, MissionTheme mission_theme);
	public List<Mission> getLikedMission(User user);
	public List<User> loadAllUserOnSearch();
	public int getRatingCount(Mission mission);
	public Double getAverageRatings(Mission mission);
	public void save(MissionRating mission_rating1);
	public void saveorupdate(MissionRating mission_rating1);
	public void delete(MissionRating mission_rating1);
	public List<Comment> getAllComments(Mission mission);
	public List<MissionDocument> loadAllDocuments(Mission mission);
	public List<MissionSkill> loadMissionSkills(Mission mission);
	public List<MissionApplication> loadRecentVolunteers(Mission mission, int currentPage);
	public int loadTotalRecentVolunteers(Mission mission);
}
