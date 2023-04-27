package com.CIplatform.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.User;
import com.entities.User.type;
import com.entities.CmsPage;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.MissionApplication.approval;
import com.entities.MissionTheme;
import com.entities.Story;
import com.entities.Story.status;
@Component
public class AdminDao implements AdminDaoInterface{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<User> loadAllUsersForAdmin() {
		String que = "from User where type=:type and (deleted_at is null)";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("type", type.VOLUNTEER);
		return q.list();
	}

	public List<Mission> loadAllMissionForAdmin() {
		String que = "from Mission where (deleted_at is null)";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		return q.list();
	}
	public List<MissionTheme> loadAllThemesForAdmin() {
		String que = "from MissionTheme where (deleted_at is null)";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		return q.list();
	}
	public List<MissionApplication> loadAllApplicationForAdmin() {
		String que = "from MissionApplication where approval_status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("status", approval.TWO);
		return q.list();
	}
	public List<Story> loadAllStoryForAdmin() {
		String que = "from Story where status=:status and (deleted_at is null)";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("status", status.PENDING);
		return q.list();
	}
	public List<CmsPage> loadAllCmsForAdmin() {
		String que = "from CmsPage where status=:status and (deleted_at is null)";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("status", com.entities.CmsPage.status.ZERO);
		return q.list();
	}
}
