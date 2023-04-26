package com.CIplatform.controller;

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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.CIplatform.dto.ShareStoryDto;
import com.CIplatform.service.MissionLoader;
import com.CIplatform.service.StoryLoader;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.Story;
import com.entities.StoryMedia;
import com.entities.User;
import com.entities.Story.status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class StoryController {
	
	@Autowired
	StoryLoader service;
	
	@Autowired
	MissionLoader service1;
	
	@RequestMapping(path = "/storiesLoader", method = RequestMethod.POST)
	public String myFormHandler(@RequestParam("uid") int userId,Model m) {
		User user=this.service1.getUserById(userId);
		m.addAttribute("user",user);
		return "story";
	}
	@RequestMapping(value = "/loadAllStories")
	public @ResponseBody String loadAllStories(@RequestParam("currentPage") int currentPage) {
		List<Story> mylist = this.service.loadAllStories(currentPage);
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
		User user=this.service1.getUserById(userId);
		m.addAttribute("user",user);
		return "ShareYourStory";
	}
	@RequestMapping(value = "/loadApprovedMissions")
	public @ResponseBody String loadApprovedMissions(@RequestParam("user_id") int user_id) {
		User user=this.service1.getUserById(user_id);
		List<MissionApplication> mylist =this.service.loadApprovedMissions(user);
		ObjectMapper obj = new ObjectMapper();
		String Output = "";
		try {
			Output = obj.writeValueAsString(mylist);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Output;
	}
	@RequestMapping(value = "/loadDraft")
	public @ResponseBody String loadDraft(@RequestParam("user_id") int user_id,@RequestParam("mission_id") int mission_id) {
		User user=this.service1.getUserById(user_id);
		Mission mission=this.service1.getMissionById(mission_id);
		Story mylist =this.service.loadDraft(user,mission);
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
	@RequestMapping(value = "/loadDraftMedia")
	public @ResponseBody List<StoryMedia> loadDraftMedia(@RequestParam("user_id") int user_id,@RequestParam("mission_id") int mission_id) {
		User user=this.service1.getUserById(user_id);
		Mission mission=this.service1.getMissionById(mission_id);
		Story story =this.service.loadDraft(user,mission);
		List<StoryMedia> storyMedia =this.service.loadDraftMediaOfStory(story);
		return storyMedia;
	}
	@RequestMapping(value = "/saveStoryToDraft",method = RequestMethod.POST)
	public @ResponseBody boolean saveStoryToDraft(ShareStoryDto shareStoryObject) {
		User user=this.service1.getUserById(shareStoryObject.getUser_id());
		Mission mission=this.service1.getMissionById(shareStoryObject.getChekedMission());
		this.service.saveDraft(shareStoryObject,user,mission);
//		for(CommonsMultipartFile x : shareStoryObject.getFiles()) {
//			System.out.println(x.getOriginalFilename());
//		}
		return true;
	}
	@RequestMapping(value = "/submitStory")
	public @ResponseBody boolean submitStory(@RequestParam("missionSelect") int missionSelect,@RequestParam("user_id") int user_id) {
		User user=this.service1.getUserById(user_id);
		Mission mission=this.service1.getMissionById(missionSelect);
		this.service.submitStory(mission,user);
		return true;
	}
	@RequestMapping(value = "/loadStoryStatus")
	public @ResponseBody status loadStoryStatus(@RequestParam("missionSelect") int missionSelect,@RequestParam("user_id") int user_id) {
		User user=this.service1.getUserById(user_id);
		Mission mission=this.service1.getMissionById(missionSelect);
		return this.service.loadStoryStatus(mission,user);
	}
	@RequestMapping(value = "/previewStory",method = RequestMethod.POST)
	public String previewStory(@RequestParam("missionSelect") int missionSelect,@RequestParam("user_id") int user_id,@RequestParam("sharedby_user_id") int sb_user_id,Model m) {
		User user=this.service1.getUserById(user_id);
		User user1=this.service1.getUserById(sb_user_id);
		Mission mission=this.service1.getMissionById(missionSelect);
		Story story= this.service.savePreviewDraft(mission,user);
		m.addAttribute("story",story);
		m.addAttribute("user",user);
		m.addAttribute("user1",user1);
		return "StoryDetail";
	}
	@RequestMapping(value = "/recommendMissionFromStory", method = RequestMethod.GET)
	public @ResponseBody String recommend(@RequestParam("mid") int missionId,@RequestParam("email") String email,@RequestParam("from") int from_uid) {
		Mission mission=this.service1.getMissionById(missionId);
		User user=this.service1.getUserById(from_uid);
		String result = this.service.recommendToCoWorker(mission,email,user);
		return "true";
	}
	@RequestMapping(value = "/openMission",method = RequestMethod.GET)
	public String openMission(@RequestParam("mission_id") int missionid,@RequestParam("user_id") int user_id,Model m) {
		User user=this.service1.getUserById(user_id);
		Mission mission=this.service1.getMissionById(missionid);
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
	public String showDetailsStory(@RequestParam("user_id") int user_id,@RequestParam("storydetails") int story_id,Model m) {
		User user=this.service1.getUserById(user_id);
		Story story=this.service1.getStoryById(story_id);
		List<StoryMedia> medias=this.service.loadDraftMediaOfStory(story);
		m.addAttribute("story",story);
		m.addAttribute("user",user);
		m.addAttribute("user1",story.getUser());
		m.addAttribute("medias",medias);
		
		return "StoryDetail";
	}
	
}
