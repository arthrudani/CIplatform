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
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.MissionInvite;
import com.entities.Story;
import com.entities.Story.status;
import com.entities.User;

@Service
public class StoryLoaderService implements StoryLoader{
	@Autowired
	StoryLoaderInterface storyLoaderInterface;
	
	@Autowired
	HibernateTemplate hibernateTemplate;


	public List<Story> loadAllStories(int currentPage) {
		return this.storyLoaderInterface.loadAllMissionOnSearch(currentPage);
	}

	public int loadNumberOfStoriesForPagination() {
		return this.storyLoaderInterface.loadNumberOfStoriesForPagination();
	}

	public List<MissionApplication> loadApprovedMissions(User user) {
		return this.storyLoaderInterface.loadApprovedMissions(user);
	}

	public Story loadDraft(User user, Mission mission) {
		return this.storyLoaderInterface.loadDraft(user,mission);
	}

	public void submitStory(Mission mission, User user) {
		this.storyLoaderInterface.submitStory(mission,user);
		
	}

	public status loadStoryStatus(Mission mission, User user) {
		return this.storyLoaderInterface.loadStoryStatus(mission,user);
	}

	public Story savePreviewDraft(Mission mission, User user) {
		Story story= this.storyLoaderInterface.savePreviewDraft(mission,user);
		return story;
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

	public void saveDraft(ShareStoryDto shareStoryObject,User user,Mission mission) {
		this.storyLoaderInterface.saveDraft(shareStoryObject,user,mission);
	}

	public List<StoryMedia> loadDraftMediaOfStory(Story story) {
		return this.storyLoaderInterface.loadDraftMedia(story);
	}


}
