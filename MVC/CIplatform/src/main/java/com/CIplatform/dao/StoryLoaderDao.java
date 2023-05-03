package com.CIplatform.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.CIplatform.dto.ShareStoryDto;
import com.entities.Country;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.MissionApplication.approval;
import com.entities.Story;
import com.entities.StoryMedia;
import com.entities.User;
import com.entities.Story.status;
@Component
public class StoryLoaderDao implements StoryLoaderInterface {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Story> loadAllMissionOnSearch(int cp) {
		int firstresultcount=0;
		int currentPage=cp;
		if(cp<0) {
			currentPage=0;
		}
		firstresultcount = ((currentPage-1) * 3) + 3;
		String que = "from Story where status=:status and (deleted_at is null)";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("status",status.PUBLISHED);
		q.setFirstResult(firstresultcount);
		q.setMaxResults(3);
		List<Story> mylist=q.list();
		return mylist;
	}

	public int loadNumberOfStoriesForPagination() {
		String que = "from Story where status=:status and (deleted_at is null)";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("status",status.PUBLISHED);
		return q.list().size();
	}

	
	public List<MissionApplication> loadApprovedMissions(User user) {
		String que = "from MissionApplication where user=:user and approval_status=:status and (deleted_at is null)";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user",user);
		q.setParameter("status",approval.ONE);
		return q.list();
	}

	public Story loadDraft(User user, Mission mission) {
		String que = "from Story where user=:user and mission=:mission and status=:status and (deleted_at is null)";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user",user);
		q.setParameter("mission",mission);
		q.setParameter("status",status.DRAFT);
		return (Story) q.uniqueResult();
	}

	
	@Transactional
	public void submitStory(Mission mission, User user) {
		String que = "from Story where user=:user and mission=:mission and status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user",user);
		q.setParameter("mission",mission);
		q.setParameter("status",status.DRAFT);
		Story story=new Story();
		if(q.list().size()>0) {
			story=(Story)q.list().get(0);
		}
		else {
			story.setMission(mission);
			story.setUser(user);
		}
		story.setTotalViews(0);
		story.setStatus(status.PENDING);
		this.hibernateTemplate.saveOrUpdate(story);
	}

	public status loadStoryStatus(Story story) {
		String que = "from Story where story_id=:id";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("id",story.getStory_id());
		Story story1=(Story) q.uniqueResult();
		if(story1==null) {
			return status.DRAFT;
		}
		else {
			return story1.getStatus();
		}
	}

	@Transactional
	public Story savePreviewDraft(Mission mission, User user) {
		String que = "from Story where user=:user and mission=:mission and status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user",user);
		q.setParameter("mission",mission);
		q.setParameter("status",status.DRAFT);
		Story story=new Story();
		if(q.list().size()>0) {
			story=(Story)q.list().get(0);
		}
		return story;
	}

	@Transactional
	public void saveDraft(ShareStoryDto shareStoryObject,User user,Mission mission) {
		String que = "from Story where user=:user and mission=:mission and status=:status";
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que);
		q.setParameter("user",user);
		q.setParameter("mission",mission);
		q.setParameter("status",status.DRAFT);
		Story story=new Story();
		if(q.list().size()>0) {
			story=(Story)q.list().get(0);
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

	public List<StoryMedia> loadDraftMedia(Story story) {
		String que = "from StoryMedia where story_id=:story_id";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("story_id",story.getStory_id());
		return q.list();
	}

}
