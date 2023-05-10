package com.CIplatform.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.CIplatform.dto.Filters;
import com.entities.City;
import com.entities.CmsPage;
import com.entities.Country;
import com.entities.FavouriteMission;
import com.entities.Mission;
import com.entities.MissionSkill;
import com.entities.MissionTheme;
import com.entities.Notifications;
import com.entities.Skill;
import com.entities.Story;
import com.entities.Timesheet;
import com.entities.User;
import com.entities.MissionApplication.approval;
import com.entities.MissionMedia;


@Service
public interface MissionLoader {
	public String loadAllMissionOnSearch(Filters filters);
	public List<Country> loadListOfCountry();
	public List<City> loadCityOfCountry(int country_id);
	public List<MissionTheme> loadAllThemes();
	public List<Mission> loadAllMission();
	public List<Skill> loadAllSkill();
	public Mission getMissionById(int missionId);
	public User getUserById(int userId);
	public String addToFavourite(int mID, int uID);
	public City getCityForRelated(String CMCT);
	public Country getCountryForRelated(String CMCR);
	public MissionTheme getThemeForRelated(String CMT);
	public String loadRelatedMissions(Mission mission, City city, Country country, MissionTheme mission_theme);
	public List<Mission> loadLikedMission(User user);
	public List<User> loadAllUsers();
	public Double getRatings(Mission mission);
	public String rateMission(int mID, int uID, int ratings);
	public int getRatingsOfCurrent(int mID, int uID);
	public String recommendToCoWorker(Mission mission, String email, User user);
	public String addComment(Mission mission, String comment, User user);
	public String loadAllComment(Mission mission);
	public String loadAllDocuments(Mission mission);
	public String loadMissionSkills(Mission mission);
	public void applyForMission(Mission mission, User user);
	public approval appliedOrNotForMission(Mission mission, User user);
	public String loadRecentVolunteers(Mission mission, int currentPage);
	public int loadTotalRecentVolunteers(Mission mission);
	public Story getStoryById(int story_id);
	public List<CmsPage> loadAllSlugs();
	public String checkEmail(String email);
	public List<MissionMedia> getMissionMedia(Mission mission);
	public boolean loadAppliedMissions(User user, Mission mission);
	public List<Notifications> loadAllNotifications(int userId);
	public boolean clearAllNotification(int userId);
}
