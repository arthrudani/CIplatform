package com.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dao.MissionLoaderInterface;
import com.dao.StoryLoaderInterface;
import com.dto.ShareStoryDto;
import com.entities.StoryMedia;
import com.entities.mission;
import com.entities.mission_application;
import com.entities.mission_invite;
import com.entities.story;
import com.entities.story.status;
import com.entities.user;

@Service
public class StoryLoaderService implements StoryLoader{
	@Autowired
	StoryLoaderInterface storyLoaderInterface;
	
	@Autowired
	HibernateTemplate hibernateTemplate;


	public List<story> loadAllStories(int currentPage) {
		return this.storyLoaderInterface.loadAllMissionOnSearch(currentPage);
	}

	public int loadNumberOfStoriesForPagination() {
		return this.storyLoaderInterface.loadNumberOfStoriesForPagination();
	}

	public List<mission_application> loadApprovedMissions(user user) {
		return this.storyLoaderInterface.loadApprovedMissions(user);
	}

	public story loadDraft(user user, mission mission) {
		return this.storyLoaderInterface.loadDraft(user,mission);
	}

	public void submitStory(mission mission, user user) {
		this.storyLoaderInterface.submitStory(mission,user);
		
	}

	public status loadStoryStatus(mission mission, user user) {
		return this.storyLoaderInterface.loadStoryStatus(mission,user);
	}

	public story savePreviewDraft(mission mission, user user) {
		story story= this.storyLoaderInterface.savePreviewDraft(mission,user);
		return story;
	}
	@Transactional
	public String recommendToCoWorker(mission mission,String email,user user) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from user where email=:email");
		query.setParameter("email", email);
		user touser=(com.entities.user) query.uniqueResult();
		
		mission_invite mission_invite=new mission_invite();
		mission_invite.setCreated_at(new Date());
		mission_invite.setMission(mission);;
		mission_invite.setTo_user(touser);
		mission_invite.setFrom_user(user);
		this.hibernateTemplate.save(mission_invite);
		
		SendMailSSL.send("arthrudanitatvasoft@gmail.com", "unydsjatgfbcbawb", email, "You are recommended to ","http://localhost:8080/CIplatform/VolunteeringMission?mid="+mission.getMission_id()+"&uid="+user.getUser_id());
		return null;
	}

	public void saveDraft(ShareStoryDto shareStoryObject,user user,mission mission) {
		this.storyLoaderInterface.saveDraft(shareStoryObject,user,mission);
	}

	public List<StoryMedia> loadDraftMediaOfStory(story story) {
		return this.storyLoaderInterface.loadDraftMedia(story);
	}


}
