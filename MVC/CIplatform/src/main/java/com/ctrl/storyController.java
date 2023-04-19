package com.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.mission;
import com.entities.mission_application;
import com.entities.story;
import com.entities.story.status;
import com.entities.user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.missionLoader;
import com.service.storyLoader;

@Controller
public class storyController {
	
	@Autowired
	storyLoader service;
	
	@Autowired
	missionLoader service1;
	
	@RequestMapping(path = "/storiesLoader", method = RequestMethod.POST)
	public String myFormHandler(@RequestParam("uid") int userId,Model m) {
		user user=this.service1.getUserById(userId);
		m.addAttribute("user",user);
		return "story";
	}
	@RequestMapping(value = "/loadAllStories")
	public @ResponseBody String loadAllStories(@RequestParam("currentPage") int currentPage) {
		List<story> mylist = this.service.loadAllStories(currentPage);
		ObjectMapper obj = new ObjectMapper();
		String Output = "";
		try {
			Output = obj.writeValueAsString(mylist);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Output;
	}
	@RequestMapping(value = "/loadNumberOfStoriesForPagination")
	public @ResponseBody int loadNumberOfStoriesForPagination() {
		return this.service.loadNumberOfStoriesForPagination();
	}
	@RequestMapping(value = "/shareYourStory")
	public String shareYourStory(@RequestParam("uid") int userId,Model m) {
		user user=this.service1.getUserById(userId);
		m.addAttribute("user",user);
		return "ShareYourStory";
	}
	@RequestMapping(value = "/loadApprovedMissions")
	public @ResponseBody String loadApprovedMissions(@RequestParam("user_id") int user_id) {
		user user=this.service1.getUserById(user_id);
		List<mission_application> mylist =this.service.loadApprovedMissions(user);
		ObjectMapper obj = new ObjectMapper();
		String Output = "";
		try {
			Output = obj.writeValueAsString(mylist);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Output;
	}
	
	@RequestMapping(value = "/loadDraft")
	public @ResponseBody String loadDraft(@RequestParam("user_id") int user_id,@RequestParam("mission_id") int mission_id) {
		user user=this.service1.getUserById(user_id);
		mission mission=this.service1.getMissionById(mission_id);
		story mylist =this.service.loadDraft(user,mission);
		ObjectMapper obj = new ObjectMapper();
		String Output = "";
		try {
			Output = obj.writeValueAsString(mylist);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Output;
	}
//	@RequestMapping(value = "/saveStoryToDraft",method = RequestMethod.GET)
//	public @ResponseBody boolean saveStoryToDraft(@RequestParam("storyTitle") String storyTitle,@RequestParam("storyDate") Date storyDate,@RequestParam("description") String description,@RequestParam("videoURL") String videoURL,@RequestParam("images") ArrayList images,@RequestParam("missionSelect") int missionSelect,@RequestParam("user_id") int user_id,@RequestParam("storyStatus") status status) {
//		System.out.println(images);
//		user user=this.service1.getUserById(user_id);
//		mission mission=this.service1.getMissionById(missionSelect);
//		this.service.saveDraft(storyTitle,storyDate,description,videoURL,mission,user,status);
//		return true;
//	}
	@RequestMapping(value = "/saveStoryToDraft",method = RequestMethod.GET)
	public @ResponseBody boolean saveStoryToDraft(@RequestParam("storyTitle") String storyTitle,@RequestParam("storyDate") Date storyDate,@RequestParam("description") String description,@RequestParam("videoURL") String videoURL,@RequestParam("missionSelect") int missionSelect,@RequestParam("user_id") int user_id,@RequestParam("storyStatus") status status) {
//		System.out.println(images);
		user user=this.service1.getUserById(user_id);
		mission mission=this.service1.getMissionById(missionSelect);
		this.service.saveDraft(storyTitle,storyDate,description,videoURL,mission,user,status);
		return true;
	}
	@RequestMapping(value = "/submitStory")
	public @ResponseBody boolean submitStory(@RequestParam("missionSelect") int missionSelect,@RequestParam("user_id") int user_id) {
		user user=this.service1.getUserById(user_id);
		mission mission=this.service1.getMissionById(missionSelect);
		this.service.submitStory(mission,user);
		return true;
	}
	@RequestMapping(value = "/loadStoryStatus")
	public @ResponseBody status loadStoryStatus(@RequestParam("missionSelect") int missionSelect,@RequestParam("user_id") int user_id) {
		user user=this.service1.getUserById(user_id);
		mission mission=this.service1.getMissionById(missionSelect);
		return this.service.loadStoryStatus(mission,user);
	}
	@RequestMapping(value = "/previewStory",method = RequestMethod.POST)
	public String previewStory(@RequestParam("missionSelect") int missionSelect,@RequestParam("user_id") int user_id,@RequestParam("sharedby_user_id") int sb_user_id,Model m) {
		user user=this.service1.getUserById(user_id);
		user user1=this.service1.getUserById(sb_user_id);
		mission mission=this.service1.getMissionById(missionSelect);
		story story= this.service.savePreviewDraft(mission,user);
		m.addAttribute("story",story);
		m.addAttribute("user",user);
		return "StoryDetail";
	}
	@RequestMapping(value = "/recommendMissionFromStory", method = RequestMethod.GET)
	public @ResponseBody String recommend(@RequestParam("mid") int missionId,@RequestParam("email") String email,@RequestParam("from") int from_uid) {
		mission mission=this.service1.getMissionById(missionId);
		user user=this.service1.getUserById(from_uid);
		String result = this.service.recommendToCoWorker(mission,email,user);
		return "true";
	}
	@RequestMapping(value = "/openMission",method = RequestMethod.GET)
	public String openMission(@RequestParam("mission_id") int missionid,@RequestParam("user_id") int user_id,Model m) {
		user user=this.service1.getUserById(user_id);
		mission mission=this.service1.getMissionById(missionid);
		m.addAttribute("user",user);
		m.addAttribute("mission",mission);
		Double rating=this.service1.getRatings(mission);
		m.addAttribute("mission",mission);
		m.addAttribute("user",user);
		m.addAttribute("rating",rating);
		m.addAttribute("user_id",user.getUser_id());
		m.addAttribute("avgrating",rating);
		return "VolunteeringMission";
	}
	@RequestMapping(value = "/showDetailsStory",method = RequestMethod.POST)
	public String showDetailsStory(@RequestParam("user_id") int user_id,@RequestParam("storydetails") story story,Model m) {
		user user=this.service1.getUserById(user_id);
		m.addAttribute("story",story);
		m.addAttribute("user",user);
		return "StoryDetail";
	}
	
}
