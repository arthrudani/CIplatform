package com.ctrl;

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
import com.entities.city;
import com.entities.country;
import com.entities.favourite_mission;
import com.entities.mission;
import com.entities.mission_theme;
import com.entities.skill;
import com.entities.user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.missionLoader;

@Controller
public class missionController {

	@Autowired
	missionLoader service;

	@RequestMapping(value = "/loadAllMission")
	public @ResponseBody String loadAllMission() {
		List<mission> mylist = this.service.loadAllMission();
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
		List<country> mylist = this.service.loadListOfCountry();
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
		List<city> mylist = this.service.loadCityOfCountry(countryId);
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

	@RequestMapping(value = "/loadListOfTheme")
	public @ResponseBody String loadAllTheme() {
		List<mission_theme> mylist = this.service.loadAllThemes();
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
		List<skill> mylist = this.service.loadAllSkill();
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
	
	
	@RequestMapping(value = "/recommend")
	public @ResponseBody String recommend(@RequestParam("missionId") int missionId) {
		System.out.println("recommend missionId:"+missionId);
		return "true";
	}
	
	@RequestMapping(path = "/VolunteeringMission", method = RequestMethod.GET)
	public String myFormHandler(@RequestParam("mid") int missionId,@RequestParam("uid") int userId,Model m) {
		mission mission=this.service.getMissionById(missionId);
		user user=this.service.getUserById(userId);
		int rating=this.service.getRatings(mission);
		m.addAttribute("mission",mission);
		m.addAttribute("user",user);
		m.addAttribute("rating",rating);
		m.addAttribute("user_id",user.getUser_id());
		return "VolunteeringMission";
	}
	
	@RequestMapping(path = "/likemission", method = RequestMethod.GET)
	public @ResponseBody String likemission(@RequestParam("mid") int mID,@RequestParam("uid") int uID) {
		String result="";
		result=this.service.addToFavourite(mID,uID);
		return result;
	}
	
	@RequestMapping(path = "/loadAllMissionLikedByUser", method = RequestMethod.GET)
	public @ResponseBody String loadAllMissionLikedByUser(@RequestParam("uid") int userId) {
		user user=this.service.getUserById(userId);
		List<mission> result = this.service.loadLikedMission(user);
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

}
