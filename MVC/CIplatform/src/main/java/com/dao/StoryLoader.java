package com.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dto.ShareStoryDto;
import com.entities.StoryMedia;
import com.entities.country;
import com.entities.mission;
import com.entities.mission_application;
import com.entities.story;
import com.entities.story.status;
import com.entities.user;
@Component
public class StoryLoader implements StoryLoaderInterface {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<story> loadAllMissionOnSearch(int cp) {
		int firstresultcount=0;
		int currentPage=cp;
		if(cp<0) {
			currentPage=0;
		}
		firstresultcount = ((currentPage-1) * 3) + 3;
		String que = "from story where status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("status",status.PUBLISHED);
		q.setFirstResult(firstresultcount);
		q.setMaxResults(3);
		List<story> mylist=q.list();
		return mylist;
	}

	public int loadNumberOfStoriesForPagination() {
		String que = "from story where status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("status",status.PUBLISHED);
		return q.list().size();
	}

	
	public List<mission_application> loadApprovedMissions(user user) {
		String que = "from mission_application where user=:user";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user",user);
		return q.list();
	}

	public story loadDraft(user user, mission mission) {
		String que = "from story where user=:user and mission=:mission and status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user",user);
		q.setParameter("mission",mission);
		q.setParameter("status",status.DRAFT);
		return (story) q.uniqueResult();
	}

	
	@Transactional
	public void submitStory(mission mission, user user) {
		String que = "from story where user=:user and mission=:mission and status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user",user);
		q.setParameter("mission",mission);
		q.setParameter("status",status.DRAFT);
		story story=new story();
		if(q.list().size()>0) {
			story=(story)q.list().get(0);
		}
		else {
			story.setMission(mission);
			story.setUser(user);
		}
		story.setStatus(status.PENDING);
		this.hibernateTemplate.saveOrUpdate(story);
	}

	public status loadStoryStatus(mission mission, user user) {
		String que = "from story where user=:user and mission=:mission and status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user",user);
		q.setParameter("mission",mission);
		q.setParameter("status",status.DRAFT);
		story story=new story();
		if(q.list().size()>0) {
			story=(story)q.list().get(0);
			return story.getStatus();
		}
		return null;
	}

	@Transactional
	public story savePreviewDraft(mission mission, user user) {
		String que = "from story where user=:user and mission=:mission and status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user",user);
		q.setParameter("mission",mission);
		q.setParameter("status",status.DRAFT);
		story story=new story();
		if(q.list().size()>0) {
			story=(story)q.list().get(0);
		}
		return story;
	}

	@Transactional
	public void saveDraft(ShareStoryDto shareStoryObject,user user,mission mission) {
		String que = "from story where user=:user and mission=:mission and status=:status";
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que);
		q.setParameter("user",user);
		q.setParameter("mission",mission);
		q.setParameter("status",status.DRAFT);
		story story=new story();
		if(q.list().size()>0) {
			story=(story)q.list().get(0);
		}
		else {
			story.setMission(mission);
			story.setUser(user);
		}
		story.setCreated_at(shareStoryObject.getDate());
		story.setDescription(shareStoryObject.getDescription());
		story.setTitle(shareStoryObject.getTitle());
		story.setStatus(status.DRAFT);
		this.hibernateTemplate.saveOrUpdate(story);
		
		
		String que1 = "from StoryMedia where story=:story and type=:type";
		Query q1 = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que1);
		q1.setParameter("story",story);
		q1.setParameter("type","Video");
		
		StoryMedia media =  (StoryMedia) q1.uniqueResult();
		
		if(media != null) {
			media.setCreatedAt(new Date());
			media.setStory(story);
			media.setType("video");
			media.setPath(shareStoryObject.getVideoUrl());
			this.hibernateTemplate.saveOrUpdate(media);
		}
		
		String hql = "delete from StoryMedia where story=:story and type=:type";
		Query q2 = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		q2.setParameter("story",story);
		q2.setParameter("type","Image");
		q2.executeUpdate();
		     
		if(shareStoryObject.getFiles()!=null) {
			for(CommonsMultipartFile x : shareStoryObject.getFiles()) {
				StoryMedia media1=new StoryMedia();
				System.out.println(x.getOriginalFilename());
				media1.setCreatedAt(new Date());
				media1.setStory(story);
				media1.setType("Image");
				media1.setPath("images/"+x.getOriginalFilename());
				this.hibernateTemplate.save(media1);
			}
		}
			 

		
		
	}

	public List<StoryMedia> loadDraftMedia(story story) {
		String que = "from StoryMedia where story_id=:story_id";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("story_id",story.getStory_id());
		return q.list();
	}
}
