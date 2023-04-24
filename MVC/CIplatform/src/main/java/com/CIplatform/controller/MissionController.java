package com.CIplatform.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.Filters;
import com.entities.City;
import com.entities.Country;
import com.entities.FavouriteMission;
import com.entities.Mission;
import com.entities.MissionApplication.approval;
import com.entities.MissionTheme;
import com.entities.Skill;
import com.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.MissionLoader;

@Controller
public class MissionController {

	@Autowired
	MissionLoader service;

	@RequestMapping(value = "/loadAllMission")
	public @ResponseBody String loadAllMission() {
		List<Mission> mylist = this.service.loadAllMission();
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

	@RequestMapping(value = "/searchMission", method = RequestMethod.POST)
	public @ResponseBody String loadAllMissionOnSearch(@RequestParam("Filters") String filters) {
		String Output = "";
		ObjectMapper obj = new ObjectMapper();
		try {
			Filters filter = obj.readValue(filters, Filters.class);
			try {
				Output = obj.writeValueAsString(this.service.loadAllMissionOnSearch(filter));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Output;
	}

	@RequestMapping(value = "/loadListOfCountry")
	public @ResponseBody String loadCountryList() {
		List<Country> mylist = this.service.loadListOfCountry();
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

	@RequestMapping(value = "/loadListOfCity", method = RequestMethod.POST)
	public @ResponseBody String loadCountryList(@RequestParam("countryId") int countryId) {
		List<City> mylist = this.service.loadCityOfCountry(countryId);
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

	@RequestMapping(value = "/loadListOfTheme")
	public @ResponseBody String loadAllTheme() {
		List<MissionTheme> mylist = this.service.loadAllThemes();
		System.out.println(mylist);
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
	
	
	
	@RequestMapping(value = "/loadListOfSkill")
	public @ResponseBody String loadAllSkill() {
		List<Skill> mylist = this.service.loadAllSkill();
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
	
	
	@RequestMapping(value = "/recommendMission", method = RequestMethod.GET)
	public @ResponseBody String recommend(@RequestParam("mid") int missionId,@RequestParam("email") String email,@RequestParam("from") int from_uid) {
		Mission mission=this.service.getMissionById(missionId);
		User user=this.service.getUserById(from_uid);
		String result = this.service.recommendToCoWorker(mission,email,user);
		return "true";
	}
	
	@RequestMapping(path = "/VolunteeringMission", method = RequestMethod.GET)
	public String myFormHandler(@RequestParam("mid") int missionId,@RequestParam("uid") int userId,Model m) {
		Mission mission=this.service.getMissionById(missionId);
		User user=this.service.getUserById(userId);
		Double rating=this.service.getRatings(mission);
		m.addAttribute("mission",mission);
		m.addAttribute("user",user);
		m.addAttribute("rating",rating);
		m.addAttribute("user_id",user.getUser_id());
		m.addAttribute("avgrating",rating);
		return "VolunteeringMission";
	}
	
	@RequestMapping(path = "/likemission", method = RequestMethod.GET)
	public @ResponseBody String likemission(@RequestParam("mid") int mID,@RequestParam("uid") int uID) {
		String result="";
		result=this.service.addToFavourite(mID,uID);
		return result;
	}
	
	@RequestMapping(path = "/ratemission", method = RequestMethod.GET)
	public @ResponseBody String ratemission(@RequestParam("mid") int mID,@RequestParam("uid") int uID,@RequestParam("ratings") int ratings) {
		String result="";
		result=this.service.rateMission(mID,uID,ratings);
		return result;
	}
	
	@RequestMapping(path = "/getAverageRating", method = RequestMethod.GET)
	public @ResponseBody Double getAverageRating(@RequestParam("mid") int mID) {
		Mission mission=this.service.getMissionById(mID);
		Double result1=this.service.getRatings(mission);
		return result1;
	}
	
	@RequestMapping(path = "/loadAllMissionLikedByUser", method = RequestMethod.GET)
	public @ResponseBody String loadAllMissionLikedByUser(@RequestParam("uid") int userId) {
		User user=this.service.getUserById(userId);
		List<Mission> result = this.service.loadLikedMission(user);
		ObjectMapper obj = new ObjectMapper();
		String Output="";
		try {
			Output = obj.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Output;
	}
	
	@RequestMapping(path = "/getRatingsOfCurrent", method = RequestMethod.GET)
	public @ResponseBody int getRatingsOfCurrent(@RequestParam("mid") int mID,@RequestParam("uid") int uID) {
		int result;
		result=this.service.getRatingsOfCurrent(mID,uID);
		return result;
	}
	
	@RequestMapping(value = "/addComment", method = RequestMethod.GET)
	public @ResponseBody String addComment(@RequestParam("mid") int missionId,@RequestParam("comment") String comment,@RequestParam("uid") int userId) {
		Mission mission=this.service.getMissionById(missionId);
		User user=this.service.getUserById(userId);
		String result = this.service.addComment(mission,comment,user);
		return "true";
	}
	
	@RequestMapping(value = "/loadAllComments", method = RequestMethod.GET)
	public @ResponseBody String loadAllComments(@RequestParam("mid") int missionId) {
		Mission mission=this.service.getMissionById(missionId);
		String result = this.service.loadAllComment(mission);
		return result;
	}

	@RequestMapping(value = "/loadAllDocuments", method = RequestMethod.GET)
	public @ResponseBody String loadAllDocuments(@RequestParam("mid") int missionId) {
		Mission mission=this.service.getMissionById(missionId);
		String result = this.service.loadAllDocuments(mission);
		return result;
	}

	@RequestMapping(value = "/loadMissionSkills", method = RequestMethod.GET)
	public @ResponseBody String loadMissionSkills(@RequestParam("mid") int missionId) {
		Mission mission=this.service.getMissionById(missionId);
		String result = this.service.loadMissionSkills(mission);
		return result;
	}
	
	@RequestMapping(value = "/applyForMission", method = RequestMethod.GET)
	public @ResponseBody void applyForMission(@RequestParam("mid") int missionId,@RequestParam("uid") int userId) {
		Mission mission=this.service.getMissionById(missionId);
		User user=this.service.getUserById(userId);
		this.service.applyForMission(mission,user);
	}
	
	@RequestMapping(value = "/appliedOrNotForMission", method = RequestMethod.GET)
	public @ResponseBody approval appliedOrNotForMission(@RequestParam("mid") int missionId,@RequestParam("uid") int userId) {
		Mission mission=this.service.getMissionById(missionId);
		User user=this.service.getUserById(userId);
		approval result=this.service.appliedOrNotForMission(mission,user);
		
		return result;
	}
	
	@RequestMapping(value = "/loadRecentVolunteers", method = RequestMethod.GET)
	public @ResponseBody String loadRecentVolunteers(@RequestParam("mid") int missionId,@RequestParam("currentPage") int currentPage) {
		Mission mission=this.service.getMissionById(missionId);
		String result=this.service.loadRecentVolunteers(mission,currentPage);
		return result;
	}
	
	@RequestMapping(value = "/loadTotalRecentVolunteers", method = RequestMethod.GET)
	public @ResponseBody int loadTotalRecentVolunteers(@RequestParam("mid") int missionId) {
		Mission mission=this.service.getMissionById(missionId);
		int result=this.service.loadTotalRecentVolunteers(mission);
		System.out.println("total recent volunt:"+result);
		return result;
	}
	

}
