package com.CIplatform.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.CIplatform.dao.AdminDaoInterface;
import com.CIplatform.dto.AddCmsDto;
import com.CIplatform.dto.AddNewMissionDto;
import com.CIplatform.dto.AddNewUserDto;
import com.entities.Banner;
import com.entities.City;
import com.entities.CmsPage;
import com.entities.Country;
import com.entities.GoalMission;
import com.entities.Mission;
import com.entities.Mission.Status;
import com.entities.Mission.mission_type;
import com.entities.MissionApplication;
import com.entities.MissionApplication.approval;
import com.entities.MissionDocument;
import com.entities.MissionMedia;
import com.entities.MissionMedia.defaultype;
import com.entities.MissionSkill;
import com.entities.MissionTheme;
import com.entities.Skill;
import com.entities.Story;
import com.entities.StoryMedia;
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
			Mission mission=missionApplication.getMission();
			int seatLeft=mission.getSeatsLeft();
			seatLeft=seatLeft-1;
			mission.setSeatsLeft(seatLeft);
			missionApplication.setApproval_status(approval.ONE);;
			this.hibernateTemplate.saveOrUpdate(missionApplication);
			this.hibernateTemplate.saveOrUpdate(mission);
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
			story.setDeleted_at(new Date());
			story.setStatus(status.DELINED);
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
	@Transactional
	public void saveNewMission(AddNewMissionDto addNewMissionDto) {
		Mission mission=new Mission();
		Country country=this.hibernateTemplate.get(Country.class,addNewMissionDto.getCountry());
		City city=this.hibernateTemplate.get(City.class,addNewMissionDto.getCity());
		MissionTheme missionTheme=this.hibernateTemplate.get(MissionTheme.class,addNewMissionDto.getThemeId());
		mission.setCreated_at(new Date());
		mission.setTitle(addNewMissionDto.getTitle());
		mission.setShort_description(addNewMissionDto.getShortDescription());
		mission.setDescription(addNewMissionDto.getDescription());
		mission.setCountry(country);
		mission.setCity(city);
		mission.setSeats(addNewMissionDto.getTotalSeats());
		mission.setStatus(Status.ACTIVE);
		mission.setMission_type(addNewMissionDto.getType());
		mission.setOrganization_name(addNewMissionDto.getOrganizationName());
		mission.setOrganization_detail(addNewMissionDto.getOrganizationDetail());
		mission.setStart_date(addNewMissionDto.getStartDate());
		mission.setEnd_date(addNewMissionDto.getEndDate());
		mission.setMission_theme(missionTheme);
		mission.setAvailability(addNewMissionDto.getAvailability());
		this.hibernateTemplate.save(mission);
		if(addNewMissionDto.getType()==mission_type.GOAL) {
			GoalMission goalMission=new GoalMission();
			goalMission.setCreatedAt(new Date());
			goalMission.setMission(mission);
			this.hibernateTemplate.save(goalMission);
		}
		for(int j=0;j<addNewMissionDto.getSkill().length;j++) {
			MissionSkill missionSkill=new MissionSkill();
			Skill skill=this.hibernateTemplate.get(Skill.class, addNewMissionDto.getSkill()[j]);
			missionSkill.setCreated_at(new Date());
			missionSkill.setMission(mission);
			missionSkill.setSkill(skill);
			this.hibernateTemplate.save(missionSkill);
		}
		int i=0;
		MissionMedia media11=new MissionMedia();
		media11.setPath(addNewMissionDto.getVideoUrl());
		media11.setCreatedAt(new Date());
		media11.setType("Video");
		this.hibernateTemplate.save(media11);
		if(addNewMissionDto.getImages()!=null) {
			for(CommonsMultipartFile x : addNewMissionDto.getImages()) {
				i++;
				MissionMedia media1=new MissionMedia();
				media1.setCreatedAt(new Date());
				media1.setMission(mission);
				if(i==0) {
					media1.setDefaultype(defaultype.ONE);
				}
				else {
					media1.setDefaultype(defaultype.ZERO);
				}
				media1.setName(x.getOriginalFilename());
				media1.setType("Image");
				media1.setPath("images/"+x.getOriginalFilename());
				this.hibernateTemplate.save(media1);
			}
		}
		if(addNewMissionDto.getDocuments()!=null) {
			for(CommonsMultipartFile x : addNewMissionDto.getDocuments()) {
				MissionDocument missionDocument=new MissionDocument();
				missionDocument.setCreated_at(new Date());
				missionDocument.setMission(mission);
				missionDocument.setDocument_name(x.getOriginalFilename());
				missionDocument.setDocument_type(x.getContentType());
				missionDocument.setDocument_path("MissionDocuments/"+x.getOriginalFilename());
				this.hibernateTemplate.save(missionDocument);
			}
		}
	}
	@Transactional
	public void editMission(AddNewMissionDto editMissionObject) {
		String que1 = "from MissionMedia where mission_id=:id";
		Query q1 = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que1);
		q1.setParameter("id", editMissionObject.getMissionId());
		Mission mission=this.hibernateTemplate.get(Mission.class, editMissionObject.getMissionId());
		mission.setCity(this.hibernateTemplate.get(City.class, editMissionObject.getCity()));
		mission.setCountry(this.hibernateTemplate.get(Country.class, editMissionObject.getCountry()));
		System.out.println(editMissionObject.getStatus());
		mission.setStatus(editMissionObject.getStatus());
		if(editMissionObject.getTotalSeats()>0){
			mission.setSeats(editMissionObject.getTotalSeats());
		}
		if(editMissionObject.getDescription()!=null) {
			mission.setDescription(editMissionObject.getDescription());
		}
		if(editMissionObject.getEndDate()!=null) {
			mission.setEnd_date(editMissionObject.getEndDate());
		}
		if(editMissionObject.getOrganizationDetail()!=null) {
			mission.setOrganization_detail(editMissionObject.getOrganizationDetail());
		}
		if(editMissionObject.getOrganizationName()!=null) {
			mission.setOrganization_name(editMissionObject.getOrganizationName());
		}
		if(editMissionObject.getShortDescription()!=null) {
			mission.setShort_description(editMissionObject.getShortDescription());
		}
		if(editMissionObject.getStartDate()!=null) {
			mission.setStart_date(editMissionObject.getStartDate());
		}
		if(editMissionObject.getType()!=null) {
			mission.setMission_type(editMissionObject.getType());
		}
		if(editMissionObject.getTitle()!=null) {
			mission.setTitle(editMissionObject.getTitle());
		}
		if(editMissionObject.getVideoUrl().length()>0) {
			MissionMedia media=new MissionMedia();
			media.setPath(editMissionObject.getVideoUrl());
			media.setCreatedAt(new Date());
			media.setType("Video");
			this.hibernateTemplate.save(media);
		}
		if(editMissionObject.getType()==mission_type.GOAL) {
			GoalMission goalMission=new GoalMission();
			goalMission.setCreatedAt(new Date());
			goalMission.setMission(mission);
			this.hibernateTemplate.save(goalMission);
		}
		String que = "delete from MissionSkill where mission_id=:id";
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que);
		q.setParameter("id", editMissionObject.getMissionId());
		q.executeUpdate();
		for(int j=0;j<editMissionObject.getSkill().length;j++) {
			MissionSkill missionSkill=new MissionSkill();
			Skill skill=this.hibernateTemplate.get(Skill.class, editMissionObject.getSkill()[j]);
			missionSkill.setCreated_at(new Date());
			missionSkill.setMission(mission);
			missionSkill.setSkill(skill);
			this.hibernateTemplate.save(missionSkill);
		}
		
		int i=0;
		if(editMissionObject.getImages()!=null) {
			for(CommonsMultipartFile x : editMissionObject.getImages()) {
				i++;
				MissionMedia media1=new MissionMedia();
				media1.setCreatedAt(new Date());
				media1.setMission(mission);
				if(i==0) {
					media1.setDefaultype(defaultype.ONE);
				}
				else {
					media1.setDefaultype(defaultype.ZERO);
				}
				media1.setName(x.getOriginalFilename());
				media1.setType("Image");
				media1.setPath("images/"+x.getOriginalFilename());
				this.hibernateTemplate.save(media1);
			}
		}
		if(editMissionObject.getDocuments()!=null) {
			for(CommonsMultipartFile x : editMissionObject.getDocuments()) {
				MissionDocument missionDocument=new MissionDocument();
				missionDocument.setCreated_at(new Date());
				missionDocument.setMission(mission);
				missionDocument.setDocument_name(x.getOriginalFilename());
				missionDocument.setDocument_type(x.getContentType());
				missionDocument.setDocument_path("MissionDocuments/"+x.getOriginalFilename());
				this.hibernateTemplate.save(missionDocument);
			}
		}
	}
	@Transactional
	public void saveNewMissionTheme(String title, String status) {
		MissionTheme missionTheme=new MissionTheme();
		missionTheme.setCreated_at(new Date());
		missionTheme.setStatus(status);
		missionTheme.setTitle(title);
		this.hibernateTemplate.save(missionTheme);
	}
	@Transactional
	public void editTheme(int mtid, String title, String status) {
		MissionTheme missionTheme=this.hibernateTemplate.get(MissionTheme.class,mtid);
		if(title!="") {
			missionTheme.setTitle(title);
		}
		if(status!="") {
			missionTheme.setStatus(status);
		}
		missionTheme.setUpdated_at(new Date());
		this.hibernateTemplate.saveOrUpdate(missionTheme);
	}
	@Transactional
	public void deleteSkill(int skillid) {
		Skill skill=this.hibernateTemplate.get(Skill.class, skillid);
		if(skill!=null) {
			skill.setDeleted_at(new Date());
			this.hibernateTemplate.saveOrUpdate(skill);
		}
	}
	@Transactional
	public void saveNewSkill(String title, String status) {
		Skill skill=new Skill();
		skill.setCreated_at(new Date());
		if(status.equalsIgnoreCase("ACTIVE")) {
			skill.setStatus(com.entities.Skill.Status.ACTIVE);
		}
		else {
			skill.setStatus(com.entities.Skill.Status.INACTIVE);
		}
		skill.setSkill_name(title);
		this.hibernateTemplate.save(skill);
	}
	@Transactional
	public void editSkill(int skillId, String title, String status) {
		Skill skill=this.hibernateTemplate.get(Skill.class,skillId);
		if(title!="") {
			skill.setSkill_name(title);
		}
		if(status.equalsIgnoreCase("ACTIVE")) {
			skill.setStatus(com.entities.Skill.Status.ACTIVE);
		}
		else {
			skill.setStatus(com.entities.Skill.Status.INACTIVE);
		}
		skill.setUpdated_at(new Date());
		this.hibernateTemplate.saveOrUpdate(skill);
	}
	@Transactional
	public void saveNewBanner(String title, String image) {
		Banner banner=new Banner();
		banner.setCreatedAt(new Date());
		banner.setImage(image);
		banner.setText(title);
		this.hibernateTemplate.save(banner);
	}
	@Transactional
	public void deleteBanner(int bannerId) {
		Banner banner=this.hibernateTemplate.get(Banner.class,bannerId);
		banner.setDeletedAt(new Date());
		this.hibernateTemplate.saveOrUpdate(banner);
	}
	@Transactional
	public void editBanner(int bannerId, String bannerTitle, String image) {
		Banner banner=this.hibernateTemplate.get(Banner.class,bannerId);
		if(bannerTitle!="") {
			banner.setText(bannerTitle);
		}
		if(image!="") {
			banner.setImage(image);
		}
		banner.setUpdatedAt(new Date());
		this.hibernateTemplate.saveOrUpdate(banner);
	}
	
	
	public List<User> loadAllUsersForAdmin() {
		return this.adminDaoInterface.loadAllUsersForAdmin();
	}
	public List<Skill> loadAllSkillsForAdmin() {
		return this.adminDaoInterface.loadAllSkillsForAdmin();
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
	public List<Banner> loadAllBannerForAdmin() {
		return this.adminDaoInterface.loadAllBannerForAdmin();
	}


	
}
