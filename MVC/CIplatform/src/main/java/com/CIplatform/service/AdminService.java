package com.CIplatform.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.CIplatform.dao.AdminDaoInterface;
import com.entities.CmsPage;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.MissionApplication.approval;
import com.entities.MissionTheme;
import com.entities.Story;
import com.entities.Story.status;
import com.entities.User;

@Service
public class AdminService implements AdminInterface{
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	AdminDaoInterface adminDaoInterface;
	
	@Transactional
	public void deleteUser(int uid) {
		User user=this.hibernateTemplate.get(User.class, uid);
		if(user!=null) {
			user.setDeleted_at(new Date());
			this.hibernateTemplate.saveOrUpdate(user);
		}
	}
	@Transactional
	public void deleteMission(int mid) {
		Mission mission=this.hibernateTemplate.get(Mission.class, mid);
		if(mission!=null) {
			mission.setDeleted_at(new Date());
			this.hibernateTemplate.saveOrUpdate(mission);
		}
	}
	@Transactional
	public void deleteTheme(int themeid) {
		MissionTheme missionTheme=this.hibernateTemplate.get(MissionTheme.class, themeid);
		if(missionTheme!=null) {
			missionTheme.setDeleted_at(new Date());
			this.hibernateTemplate.saveOrUpdate(missionTheme);
		}
	}
	@Transactional
	public void approveMissionApplication(int applicationID) {
		MissionApplication missionApplication=this.hibernateTemplate.get(MissionApplication.class, applicationID);
		if(missionApplication!=null) {
			missionApplication.setApproval_status(approval.ONE);;
			this.hibernateTemplate.saveOrUpdate(missionApplication);
		}
	}
	@Transactional
	public void rejectMissionApplication(int applicationID) {
		MissionApplication missionApplication=this.hibernateTemplate.get(MissionApplication.class, applicationID);
		if(missionApplication!=null) {
			missionApplication.setApproval_status(approval.ZERO);;
			this.hibernateTemplate.saveOrUpdate(missionApplication);
		}
	}
	@Transactional
	public void approveStoryApplication(int applicationID) {
		Story story=this.hibernateTemplate.get(Story.class, applicationID);
		if(story!=null) {
			story.setStatus(status.PUBLISHED);;
			this.hibernateTemplate.saveOrUpdate(story);
		}
	}
	@Transactional
	public void rejectStoryApplication(int applicationID) {
		Story story=this.hibernateTemplate.get(Story.class, applicationID);
		if(story!=null) {
			story.setStatus(status.DELINED);;
			this.hibernateTemplate.saveOrUpdate(story);
		}
	}
	@Transactional
	public void deleteStoryApplication(int applicationID) {
		Story story=this.hibernateTemplate.get(Story.class, applicationID);
		if(story!=null) {
			story.setDeleted_at(new Date());;;
			this.hibernateTemplate.saveOrUpdate(story);
		}
	}
	@Transactional
	public void deleteCms(int cmsid) {
		CmsPage cmsPage=this.hibernateTemplate.get(CmsPage.class, cmsid);
		if(cmsPage!=null) {
			cmsPage.setDeletedAt(new Date());
			this.hibernateTemplate.saveOrUpdate(cmsPage);
		}
	}

	
	public List<User> loadAllUsersForAdmin() {
		return this.adminDaoInterface.loadAllUsersForAdmin();
	}
	
	public List<Mission> loadAllMissionForAdmin() {
		return this.adminDaoInterface.loadAllMissionForAdmin();
	}
	public List<MissionTheme> loadAllThemesForAdmin() {
		return this.adminDaoInterface.loadAllThemesForAdmin();
	}
	public List<MissionApplication> loadAllApplicationForAdmin() {
		return this.adminDaoInterface.loadAllApplicationForAdmin();
	}
	public List<Story> loadAllStoryForAdmin() {
		return this.adminDaoInterface.loadAllStoryForAdmin();
	}
	public List<CmsPage> loadAllCmsForAdmin() {
		return this.adminDaoInterface.loadAllCmsForAdmin();
	}
	
}
