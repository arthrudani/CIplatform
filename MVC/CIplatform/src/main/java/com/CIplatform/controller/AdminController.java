package com.CIplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CIplatform.service.AdminInterface;
import com.CIplatform.service.MissionLoader;
import com.entities.CmsPage;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.MissionTheme;
import com.entities.Story;
import com.entities.User;

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

