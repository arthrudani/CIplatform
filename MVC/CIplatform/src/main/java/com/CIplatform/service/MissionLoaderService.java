package com.CIplatform.service;

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

import com.CIplatform.dao.MissionLoaderInterface;
import com.CIplatform.dto.Filters;
import com.entities.City;
import com.entities.CmsPage;
import com.entities.Comment;
import com.entities.Country;
import com.entities.FavouriteMission;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.MissionDocument;
import com.entities.MissionInvite;
import com.entities.MissionMedia;
import com.entities.MissionRating;
import com.entities.MissionSkill;
import com.entities.MissionTheme;
import com.entities.Notifications;
import com.entities.Skill;
import com.entities.Story;
import com.entities.Timesheet;
import com.entities.User;
import com.entities.MissionApplication.approval;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class MissionLoaderService implements MissionLoader {

	@Autowired
	MissionLoaderInterface missionLoaderInterface;
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public List<Mission> loadAllMission() {
		return this.missionLoaderInterface.loadAllMission();
	}

	public List<Country> loadListOfCountry() {
		return missionLoaderInterface.loadListOfCountry();
	}

	public List<City> loadCityOfCountry(int country_id) {
		return this.missionLoaderInterface.loadCityOfCountry(country_id);
	}

	public List<MissionTheme> loadAllThemes() {
		return this.missionLoaderInterface.loadAllThemes();
	}
	
	public List<Skill> loadAllSkill() {
		return this.missionLoaderInterface.loadAllSkillOnSearch();
	}
	
	public List<User> loadAllUsers() {
		return this.missionLoaderInterface.loadAllUserOnSearch();
	}
	public List<CmsPage> loadAllSlugs() {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from CmsPage where (deletedAt is null)");
		return query.list();
	}
	public List<Notifications> loadAllNotifications(int userId) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from Notifications where (deletedAt is null) and user_id=:userId");
		query.setParameter("userId", userId);
		return query.list();
	}
	@Transactional
	public boolean clearAllNotification(int userId) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from Notifications where (deletedAt is null) and user_id=:userId");
		query.setParameter("userId", userId);
		List<Notifications> notifications= query.list();
		for(int i=0;i<notifications.size();i++) {
			Notifications notifications2=notifications.get(i);
			notifications2.setDeletedAt(new Date());
			this.hibernateTemplate.saveOrUpdate(notifications2);
		}
		return true;
	}

	public String loadAllMissionOnSearch(Filters filters) {
		Map<Long, List<Mission>> map=new HashMap<Long,List<Mission>>();
		String output="";
		ObjectMapper obj=new ObjectMapper();
		Long totalmission=this.missionLoaderInterface.countAllMission(filters);
		List<Mission> missions=this.missionLoaderInterface.loadAllMissionOnSearch(filters);
		map.put(totalmission, missions);
		try {
			output=obj.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return output;
	}

	public Mission getMissionById(int missionId) {
		return this.hibernateTemplate.get(Mission.class, missionId);
	}


	public User getUserById(int userId) {
		return this.hibernateTemplate.get(User.class, userId);
	}

	public String addToFavourite(int mID, int uID) {
		Mission mission=this.hibernateTemplate.get(Mission.class, mID);
		User user=this.hibernateTemplate.get(User.class, uID);
		
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from FavouriteMission where mission_id=:mission_id and user_id=:user_id");
		query.setParameter("mission_id", mID);
		query.setParameter("user_id", uID);
		FavouriteMission favourite_mission1 = (FavouriteMission) query.uniqueResult();
		
		if(favourite_mission1==null) {
			FavouriteMission favourite_mission=new FavouriteMission();
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

	public City getCityForRelated(String CMCT) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from City where name=:name");
		query.setParameter("name", CMCT);
		City city=(com.entities.City) query.uniqueResult();
		return city;
	}

	public Country getCountryForRelated(String CMCR) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from Country where name=:name");
		query.setParameter("name", CMCR);
		Country country=(com.entities.Country) query.uniqueResult();
		return country;
	}

	public MissionTheme getThemeForRelated(String CMT) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from MissionTheme where title=:title");
		query.setParameter("title", CMT);
		MissionTheme mission_theme=(com.entities.MissionTheme) query.uniqueResult();
		return mission_theme;
	}

	public String loadRelatedMissions(Mission mission,City city, Country country, MissionTheme mission_theme) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<Mission> missions=this.missionLoaderInterface.loadrelatedmission(mission,city,country,mission_theme);
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

	public List<Mission> loadLikedMission(User user) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<Mission> liked=this.missionLoaderInterface.getLikedMission(user);
		return liked;
	}

	public Double getRatings(Mission mission) {
		
		Double sum=this.missionLoaderInterface.getAverageRatings(mission);
//		int totalRatedBy=this.missionLoaderInterface.getRatingCount(mission);
		return sum;
		
	}

	public String rateMission(int mID, int uID, int ratings) {
		Mission mission=this.hibernateTemplate.get(Mission.class, mID);
		User user=this.hibernateTemplate.get(User.class, uID);
		
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from MissionRating where mission_id=:mission_id and user_id=:user_id");
		query.setParameter("mission_id", mID);
		query.setParameter("user_id", uID);
		MissionRating mission_rating=(MissionRating) query.uniqueResult();
		
		if(mission_rating!=null) {
			this.missionLoaderInterface.delete(mission_rating);
		}
		else {
			
		}
		MissionRating mission_rating1=new MissionRating();
		mission_rating1.setCreated_at(new Date());
		mission_rating1.setMission(mission);
		mission_rating1.setUser(user);
		mission_rating1.setRating(ratings);
		this.missionLoaderInterface.save(mission_rating1);
		return "true";
	}

	public int getRatingsOfCurrent(int mID, int uID) {
		Mission mission=this.hibernateTemplate.get(Mission.class, mID);
		User user=this.hibernateTemplate.get(User.class, uID);
		
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from MissionRating where mission_id=:mission_id and user_id=:user_id");
		query.setParameter("mission_id", mission.getMission_id());
		query.setParameter("user_id", user.getUser_id());
		MissionRating mission_rating=(MissionRating) query.uniqueResult();
		if(mission_rating != null) {
			return mission_rating.getRating();
		}
		return 0;
	}

	@Transactional
	public String recommendToCoWorker(Mission mission,String email,User user) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from User where email=:email");
		query.setParameter("email", email);
		User touser=(com.entities.User) query.uniqueResult();
		
		MissionInvite mission_invite=new MissionInvite();
		mission_invite.setCreated_at(new Date());
		mission_invite.setMission(mission);;
		mission_invite.setTo_user(touser);
		mission_invite.setFrom_user(user);
		this.hibernateTemplate.save(mission_invite);
		
		SendMailSSL.send("arthrudanitatvasoft@gmail.com", "unydsjatgfbcbawb", email, "You are recommended to ","http://localhost:8080/CIplatform/VolunteeringMission?mid="+mission.getMission_id()+"&uid="+user.getUser_id());
		return null;
	}

	@Transactional
	public String addComment(Mission mission, String comments, User user) {
		Comment comment=new Comment();
		comment.setCreated_at(new Date());
		comment.setMission(mission);
		comment.setUser(user);
		comment.setComment(comments);
		this.hibernateTemplate.save(comment);
		return null;
	}

	public String loadAllComment(Mission mission) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<Comment> comments=this.missionLoaderInterface.getAllComments(mission);
		try {
			output=obj.writeValueAsString(comments);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	public String loadAllDocuments(Mission mission) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<MissionDocument> comments=this.missionLoaderInterface.loadAllDocuments(mission);
		try {
			output=obj.writeValueAsString(comments);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	public String loadMissionSkills(Mission mission) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<MissionSkill> comments=this.missionLoaderInterface.loadMissionSkills(mission);
		try {
			output=obj.writeValueAsString(comments);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	@Transactional
	public void applyForMission(Mission mission,User user) {
		MissionApplication application=new MissionApplication();
		application.setApplied_at(new Date());
		application.setMission(mission);
		application.setUser(user);
		application.setApproval_status(approval.TWO);
		this.hibernateTemplate.save(application);
	}
	
	public approval appliedOrNotForMission(Mission mission,User user) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from MissionApplication where mission_id=:mission_id and user_id=:user_id");
		query.setParameter("mission_id", mission.getMission_id());
		query.setParameter("user_id", user.getUser_id());
		MissionApplication application=(MissionApplication) query.uniqueResult();
		if(application!=null) {
			return application.getApproval_status();
		}
		return approval.ZERO;
	}

	public String loadRecentVolunteers(Mission mission,int currentPage) {
		String output="";
		ObjectMapper obj=new ObjectMapper();
		List<MissionApplication> users=this.missionLoaderInterface.loadRecentVolunteers(mission,currentPage);
		try {
			output=obj.writeValueAsString(users);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	public int loadTotalRecentVolunteers(Mission mission) {
		return this.missionLoaderInterface.loadTotalRecentVolunteers(mission);
	}
	@Transactional
	public Story getStoryById(int story_id) {
		Story story= this.hibernateTemplate.get(Story.class, story_id);
		int view=story.getTotalViews();
		view=view+1;
		story.setTotalViews(view);
		this.hibernateTemplate.saveOrUpdate(story);
		return story;
	}

	public String checkEmail(String email) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from User where email=:email");
		String result1="";
		query.setParameter("email", email);
		User user1 = (User) query.uniqueResult();
		if(user1!=null) {
			return "true";
		}
		else {
			return "false";
		}
	}

	public List<MissionMedia> getMissionMedia(Mission mission) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from MissionMedia where mission=:mission");
		String result1="";
		query.setParameter("mission", mission);
		return query.list();
	}

	public boolean loadAppliedMissions(User user,Mission mission) {
		String que = "from MissionApplication where user_id=:user_id and mission_id=:mission_id and approval_status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user_id", user.getUser_id());
		q.setParameter("mission_id", mission.getMission_id());
		q.setParameter("status", approval.ONE);
		MissionApplication application=(MissionApplication) q.uniqueResult();
		if(application!=null) {
			return true;
		}
		return false;
	}

}
