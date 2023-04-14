package com.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

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
	public void saveDraft(String storyTitle, Date storyDate, String description, String videoURL,mission mission,user user,status status) {
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
		story.setCreated_at(storyDate);
		story.setDescription(description);
		story.setTitle(storyTitle);
		story.setStatus(status);
		this.hibernateTemplate.saveOrUpdate(story);
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
}
