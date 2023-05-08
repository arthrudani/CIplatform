package com.CIplatform.controller;


import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CIplatform.dto.AddCmsDto;
import com.CIplatform.dto.AddNewMissionDto;
import com.CIplatform.dto.AddNewUserDto;
import com.CIplatform.dto.EditProfileObject;
import com.CIplatform.service.AdminInterface;
import com.CIplatform.service.MissionLoader;
import com.entities.Banner;
import com.entities.CmsPage;
import com.entities.GoalMission;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.MissionTheme;
import com.entities.Skill;
import com.entities.Story;
import com.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AdminController {
	@Autowired
	AdminInterface service;
	@Autowired
	MissionLoader service1;
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@RequestMapping(value = "/loadAllUsersForAdmin")
	public @ResponseBody List<User> loadAllUsersForAdmin() {
		List<User> mylist = this.service.loadAllUsersForAdmin();
		return mylist;
	}
	@RequestMapping(value = "/loadAllMissionForAdmin")
	public @ResponseBody List<Mission> loadAllMissionForAdmin() {
		List<Mission> mylist = this.service.loadAllMissionForAdmin();
		return mylist;
	}
	@RequestMapping(value = "/loadAllThemesForAdmin")
	public @ResponseBody List<MissionTheme> loadAllThemesForAdmin() {
		List<MissionTheme> mylist = this.service.loadAllThemesForAdmin();
		return mylist;
	}
	@RequestMapping(value = "/loadAllSkillsForAdmin")
	public @ResponseBody List<Skill> loadAllSkillsForAdmin() {
		List<Skill> mylist = this.service.loadAllSkillsForAdmin();
		return mylist;
	}
	@RequestMapping(value = "/loadAllApplicationForAdmin")
	public @ResponseBody List<MissionApplication> loadAllApplicationForAdmin() {
		List<MissionApplication> mylist = this.service.loadAllApplicationForAdmin();
		return mylist;
	}
	@RequestMapping(value = "/loadAllStoryForAdmin")
	public @ResponseBody List<Story> loadAllStoryForAdmin() {
		List<Story> mylist = this.service.loadAllStoryForAdmin();
		return mylist;
	}
	@RequestMapping(value = "/loadAllCmsForAdmin")
	public @ResponseBody List<CmsPage> loadAllCmsForAdmin() {
		List<CmsPage> mylist = this.service.loadAllCmsForAdmin();
		return mylist;
	}
	@RequestMapping(value = "/loadAllBannerForAdmin")
	public @ResponseBody List<Banner> loadAllBannerForAdmin() {
		List<Banner> mylist = this.service.loadAllBannerForAdmin();
		return mylist;
	}
	
	@RequestMapping(value = "/loadEditMissionDetails")
	public @ResponseBody Mission loadEditMissionDetails(@RequestParam("mid") int mid) {
		Mission mission=this.hibernateTemplate.get(Mission.class,mid);
		return mission;
	}
	@RequestMapping(value = "/loadEditMissionDetailsIfGoal")
	public @ResponseBody GoalMission loadEditMissionDetailsIfGoal(@RequestParam("mid") int mid) {
		Mission mission=this.hibernateTemplate.get(Mission.class,mid);
		String que = "from GoalMission where mission_id=:mission";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("mission", mission.getMission_id());
		GoalMission goalMission=(GoalMission) q.uniqueResult();
		return goalMission;
	}
	@RequestMapping(value = "/loadThemeDetail")
	public @ResponseBody MissionTheme loadThemeDetail(@RequestParam("themeId") int themeId) {
		MissionTheme missionTheme=this.hibernateTemplate.get(MissionTheme.class,themeId);
		return missionTheme;
	}
	@RequestMapping(value = "/loadSkillDetail")
	public @ResponseBody Skill loadSkillDetail(@RequestParam("skillId") int skillId) {
		Skill skill=this.hibernateTemplate.get(Skill.class,skillId);
		return skill;
	}
	@RequestMapping(value = "/loadBannerDetail",method = RequestMethod.POST)
	public @ResponseBody Banner loadBannerDetail(@RequestParam("bannerId") int bannerId) {
		Banner banner=this.hibernateTemplate.get(Banner.class,bannerId);
		return banner;
	}
	
	
	
	
	@RequestMapping(value = "/deleteUser")
	public @ResponseBody int deleteUser(@RequestParam("user_id") int uid) {
		this.service.deleteUser(uid);
		return 0;
	}
	@RequestMapping(value = "/deleteMission")
	public @ResponseBody int deleteMission(@RequestParam("mission_id") int mid) {
		this.service.deleteMission(mid);
		return 0;
	}
	@RequestMapping(value = "/deleteTheme")
	public @ResponseBody int deleteTheme(@RequestParam("theme_id") int themeid) {
		this.service.deleteTheme(themeid);
		return 0;
	}
	@RequestMapping(value = "/deleteSkill")
	public @ResponseBody int deleteSkill(@RequestParam("skillId") int skillId) {
		this.service.deleteSkill(skillId);
		return 0;
	}
	@RequestMapping(value = "/deleteBanner")
	public @ResponseBody int deleteBanner(@RequestParam("bannerId") int bannerId) {
		this.service.deleteBanner(bannerId);
		return 0;
	}

	
	@RequestMapping(value = "/approveMissionApplication")
	public @ResponseBody int approveMissionApplication(@RequestParam("application_Id") int applicationID) {
		this.service.approveMissionApplication(applicationID);
		return 0;
	}
	@RequestMapping(value = "/rejectMissionApplication")
	public @ResponseBody int rejectMissionApplication(@RequestParam("application_Id") int applicationID) {
		this.service.rejectMissionApplication(applicationID);
		return 0;
	}
	@RequestMapping(value = "/approveStoryApplication")
	public @ResponseBody int approveStoryApplication(@RequestParam("application_Id") int applicationID) {
		this.service.approveStoryApplication(applicationID);
		return 0;
	}
	@RequestMapping(value = "/rejectStoryApplication")
	public @ResponseBody int rejectStoryApplication(@RequestParam("application_Id") int applicationID) {
		this.service.rejectStoryApplication(applicationID);
		return 0;
	}
	@RequestMapping(value = "/deleteStoryApplication")
	public @ResponseBody int deleteStoryApplication(@RequestParam("application_Id") int applicationID) {
		this.service.deleteStoryApplication(applicationID);
		return 0;
	}
	@RequestMapping(value = "/deleteCms")
	public @ResponseBody int deleteCms(@RequestParam("cmsid") int cmsid) {
		this.service.deleteCms(cmsid);
		return 0;
	}
	@RequestMapping(value = "/addCMS")
	public String addCMS(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class, uid);
		m.addAttribute("user",user);
		return "AdminAddCMS";
	}
	@RequestMapping(value = "/addNewCms")
	public String addNewCms(AddCmsDto AddCmsObject) {
		this.service.saveNewCms(AddCmsObject);
		return "AdminCMS";
	}
	@RequestMapping(value = "/addNewUSer")
	public @ResponseBody int addNewUSer(AddNewUserDto AddUserObject) {
		int result = this.service.addNewUSer(AddUserObject);
		return result;
	}
	@RequestMapping(value = "/addNewMission")
	public @ResponseBody int addNewMission(AddNewMissionDto addNewMissionDto) {
		this.service.saveNewMission(addNewMissionDto);
		return 1;
	}
	@RequestMapping(value = "/addNewTheme")
	public @ResponseBody int addNewTheme(@RequestParam("title") String title,@RequestParam("status") String status) {
		this.service.saveNewMissionTheme(title,status);
		return 1;
	}
	@RequestMapping(value = "/addNewSkill")
	public @ResponseBody int addNewSkill(@RequestParam("title") String title,@RequestParam("status") String status) {
		this.service.saveNewSkill(title,status);
		return 1;
	}
	@RequestMapping(value = "/addNewBanner")
	public @ResponseBody int addNewBanner(@RequestParam("sortOrder") int sortOrder,@RequestParam("bannerTitle") String title,@RequestParam("image") String image) {
		this.service.saveNewBanner(title,image,sortOrder);
		return 1;
	}
	@RequestMapping(value = "/loadCmsData")
	public @ResponseBody String loadCmsData(@RequestParam("cmsid") int cmsid) {
		CmsPage cmsPage=this.hibernateTemplate.get(CmsPage.class, cmsid);
		ObjectMapper obj = new ObjectMapper();
		String Output = "";
		try {
			Output = obj.writeValueAsString(cmsPage);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Output;
	}
	@RequestMapping(value = "/editCmsPage")
	public String editCmsPage(@RequestParam("cmsid") int cmsid,@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class, uid);
		CmsPage cmsPage=this.hibernateTemplate.get(CmsPage.class, cmsid);
		m.addAttribute("cms",cmsPage);
		m.addAttribute("user",user);
		return "AdminEditCMS";
	}
	@RequestMapping(value = "/editUserPage")
	public String editUserPage(@RequestParam("uid") int uid,@RequestParam("auid") int auid,Model m) {
		User adminuser=this.hibernateTemplate.get(User.class, auid);
		User user=this.hibernateTemplate.get(User.class, uid);
		m.addAttribute("edituser",user);
		m.addAttribute("user",adminuser);
		return "AdminEditUser";
	}
	@RequestMapping(value = "/editMissionPage")
	public String editMissionPage(@RequestParam("mid") int mid,@RequestParam("auid") int auid,Model m) {
		User adminuser=this.hibernateTemplate.get(User.class, auid);
		Mission mission=this.hibernateTemplate.get(Mission.class, mid);
		m.addAttribute("mission",mission);
		m.addAttribute("user",adminuser);
		return "AdminEditMission";
	}
	@RequestMapping(value = "/editMissionThemePage")
	public String editMissionThemePage(@RequestParam("mtid") int muid,@RequestParam("auid") int auid,Model m) {
		User user=this.hibernateTemplate.get(User.class, auid);
		MissionTheme missionTheme=this.hibernateTemplate.get(MissionTheme.class,muid);
		m.addAttribute("missionTheme",missionTheme);
		m.addAttribute("user",user);
		return "AdminEditTheme";
	}
	@RequestMapping(value = "/editSkillPage")
	public String editSkillPage(@RequestParam("sid") int sid,@RequestParam("auid") int auid,Model m) {
		User user=this.hibernateTemplate.get(User.class, auid);
		Skill skill=this.hibernateTemplate.get(Skill.class,sid);
		m.addAttribute("skill",skill);
		m.addAttribute("user",user);
		return "AdminEditSkill";
	}
	@RequestMapping(value = "/editBannerPage")
	public String editBannerPage(@RequestParam("bid") int bid,@RequestParam("auid") int auid,Model m) {
		User user=this.hibernateTemplate.get(User.class, auid);
		Banner banner=this.hibernateTemplate.get(Banner.class,bid);
		m.addAttribute("banner",banner);
		m.addAttribute("user",user);
		return "AdminEditBanner";
	}

	
	
	@RequestMapping(value = "/editCms")
	public @ResponseBody String editCms(@RequestParam("cmsid") int cmsid,@RequestParam("EditCmsObject") String EditCmsObject) {
		CmsPage cmsPage=this.hibernateTemplate.get(CmsPage.class, cmsid);
		String Output = "";
		ObjectMapper obj = new ObjectMapper();
		try {
			AddCmsDto addCmsDto = obj.readValue(EditCmsObject, AddCmsDto.class);
			this.service.editCms(cmsPage,addCmsDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "true";
	}
	@RequestMapping(value = "/editUSer")
	public @ResponseBody String editUSer(@RequestParam("userid") int user_id,@RequestParam("EditUserObject") String EditUserObject) {
		User user=this.hibernateTemplate.get(User.class, user_id);
		String Output = "";
		ObjectMapper obj = new ObjectMapper();
		try {
			AddNewUserDto addNewUserDto = obj.readValue(EditUserObject, AddNewUserDto.class);
			this.service.editUser(user,addNewUserDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "true";
	}
	@RequestMapping(value = "/editMission",method = RequestMethod.POST)
	public @ResponseBody boolean editMission(AddNewMissionDto EditMissionObject) {
		this.service.editMission(EditMissionObject);
		return true;
	}
	@RequestMapping(value = "/editTheme",method = RequestMethod.POST)
	public @ResponseBody boolean editTheme(@RequestParam("mtid") int mtid,@RequestParam("title") String title,@RequestParam("status") String status) {
		this.service.editTheme(mtid,title,status);
		return true;
	}
	@RequestMapping(value = "/editSkill",method = RequestMethod.POST)
	public @ResponseBody boolean editSkill(@RequestParam("skillId") int skillId,@RequestParam("title") String title,@RequestParam("status") String status) {
		this.service.editSkill(skillId,title,status);
		return true;
	}
	@RequestMapping(value = "/editBanner",method = RequestMethod.POST)
	public @ResponseBody boolean editBanner(@RequestParam("sortOrder") int sortOrder,@RequestParam("bannerId") int bannerId,@RequestParam("bannerTitle") String bannerTitle,@RequestParam("image") String image) {
		this.service.editBanner(sortOrder,bannerId,bannerTitle,image);
		return true;
	}
	
	
	@RequestMapping(value = "/addNewUserPage")
	public String addNewUserPage(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class, uid);
		m.addAttribute("user",user);
		return "AdminAddUser";
	}
	@RequestMapping(value = "/addNewMissionPage")
	public String addNewMissionPage(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class, uid);
		m.addAttribute("user",user);
		return "AdminAddMission";
	}
	@RequestMapping(value = "/addNewThemePage")
	public String addNewThemePage(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class, uid);
		m.addAttribute("user",user);
		return "AdminAddTheme";
	}
	@RequestMapping(value = "/addNewSkillPage")
	public String addNewSkillPage(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class, uid);
		m.addAttribute("user",user);
		return "AdminAddSkill";
	}
	@RequestMapping(value = "/addNewBannerPage")
	public String addNewBannerPage(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class, uid);
		m.addAttribute("user",user);
		return "AdminAddBanner";
	}
	
	
	
	
	
	@RequestMapping(value = "/usersLoader")
	public String usersLoader(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class,uid);
		m.addAttribute("user",user);
		return "AdminUser";
	}
	@RequestMapping(value = "/cmsPageLoader")
	public String cmsPageLoader(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class,uid);
		m.addAttribute("user",user);
		return "AdminCMS";
	}
	@RequestMapping(value = "/missionLoader")
	public String missionLoader(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class,uid);
		m.addAttribute("user",user);
		return "AdminMission";
	}
	@RequestMapping(value = "/missionThemeLoader")
	public String missionThemeLoader(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class,uid);
		m.addAttribute("user",user);
		return "AdminMissionTheme";
	}
	@RequestMapping(value = "/missionSkillLoader")
	public String missionSkillLoader(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class,uid);
		m.addAttribute("user",user);
		return "AdminMissionSkill";
	}
	@RequestMapping(value = "/missionApplicationLoader")
	public String missionApplicationLoader(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class,uid);
		m.addAttribute("user",user);
		return "AdminMissionApplication";
	}
	@RequestMapping(value = "/storyLoader")
	public String storyLoader(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class,uid);
		m.addAttribute("user",user);
		return "AdminStory";
	}
	@RequestMapping(value = "/bannerManagementLoader")
	public String bannerManagementLoader(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class,uid);
		m.addAttribute("user",user);
		return "AdminBannerManagement";
	}
	
}

