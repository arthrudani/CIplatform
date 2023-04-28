package com.CIplatform.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.CIplatform.dao.AdminDaoInterface;
import com.CIplatform.dto.AddCmsDto;
import com.CIplatform.dto.AddNewUserDto;
import com.entities.City;
import com.entities.CmsPage;
import com.entities.Country;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.MissionApplication.approval;
import com.entities.MissionTheme;
import com.entities.Story;
import com.entities.Story.status;
import com.entities.User;
import com.entities.User.type;

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
	@Transactional
	public void saveNewCms(AddCmsDto addCmsObject) {
		CmsPage cmsPage=new CmsPage();
		cmsPage.setCreatedAt(new Date());
		cmsPage.setDescription(addCmsObject.getDescription());
		cmsPage.setSlug(addCmsObject.getSlug());
		cmsPage.setStatus(addCmsObject.getStatus());
		cmsPage.setTitle(addCmsObject.getTitle());
		this.hibernateTemplate.save(cmsPage);
	}
	@Transactional
	public int addNewUSer(AddNewUserDto addUserObject) {
		String que = "from User where email=:emailid";
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que);
		q.setParameter("emailid", addUserObject.getEmail());
		User user1 =   (User) q.uniqueResult();
		if(user1!=null) {
			return 0;
		}
		
		Country country=this.hibernateTemplate.get(Country.class,Integer.parseInt(addUserObject.getCountry()));
		City city=this.hibernateTemplate.get(City.class,Integer.parseInt(addUserObject.getCountry()));
		User user=new User();
		user.setCreated_at(new Date());
		user.setFirst_name(addUserObject.getFirstName());
		user.setLast_name(addUserObject.getLastName());
		user.setEmail(addUserObject.getEmail());
		user.setPassword(addUserObject.getPassword());
		user.setType(type.VOLUNTEER);
		System.out.println(addUserObject.getAvatar());
		if(addUserObject.getAvatar()=="") {
			user.setAvatar("noImageFound.png");
		}
		else {
			user.setAvatar(addUserObject.getAvatar());
		}
		user.setEmployee_id(addUserObject.getEmployeeId());
		user.setDepartment(addUserObject.getDepartment());
		user.setCity(city);
		user.setCountry(country);
		user.setProfile_text(addUserObject.getProfileText());
		System.out.println(addUserObject.getStatus());
		user.setStatus(addUserObject.getStatus());
		this.hibernateTemplate.save(user);
		return 1;
	}
	@Transactional
	public void editCms(CmsPage cmsPage, AddCmsDto editCmsObject) {
		String que = "from CmsPage where cmsPageId=:id";
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que);
		q.setParameter("id", cmsPage.getCmsPageId());
		CmsPage cmsPage1 =  (CmsPage) q.uniqueResult();
		if(editCmsObject.getDescription()!="") {
			cmsPage1.setDescription(editCmsObject.getDescription());
		}
		if(editCmsObject.getSlug()!="") {
			cmsPage1.setSlug(editCmsObject.getSlug());
		}
		if(editCmsObject.getTitle()!="") {
			cmsPage1.setTitle(editCmsObject.getTitle());
		}
		if(editCmsObject.getStatus()!=null) {
			cmsPage1.setStatus(editCmsObject.getStatus());
		}
		cmsPage1.setUpdatedAt(new Date());
		this.hibernateTemplate.saveOrUpdate(cmsPage1);
	}
	@Transactional
	public void editUser(User user, AddNewUserDto addNewUserDto) {
		String que = "from User where user_id=:id";
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que);
		q.setParameter("id", user.getUser_id());
		User user1 =  (User) q.uniqueResult();
		if(addNewUserDto.getFirstName()!="") {
			user1.setFirst_name(addNewUserDto.getFirstName());
		}
		if(addNewUserDto.getLastName()!="") {
			user1.setLast_name(addNewUserDto.getLastName());
		}
		if(addNewUserDto.getEmail()!="") {
			user1.setEmail(addNewUserDto.getEmail());
		}
		if(addNewUserDto.getPassword()!=null) {
			user1.setPassword(addNewUserDto.getPassword());
		}
		if(addNewUserDto.getAvatar()!="") {
			user1.setAvatar(addNewUserDto.getAvatar());
		}
		if(addNewUserDto.getCountry()!=null) {
			Country country=this.hibernateTemplate.get(Country.class,Integer.parseInt(addNewUserDto.getCountry()));
			user1.setCountry(country);
		}
		if(addNewUserDto.getCity()!=null) {
			City city=this.hibernateTemplate.get(City.class,Integer.parseInt(addNewUserDto.getCity()));
			user1.setCity(city);
		}
		if(addNewUserDto.getProfileText()!="") {
			user1.setProfile_text(addNewUserDto.getProfileText());
		}
		if(addNewUserDto.getStatus()!=null) {
			user1.setStatus(addNewUserDto.getStatus());
		}
		user1.setEmployee_id(addNewUserDto.getEmployeeId());
		
		user1.setUpdated_at(new Date());
		this.hibernateTemplate.saveOrUpdate(user1);
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
