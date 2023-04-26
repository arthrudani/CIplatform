package com.CIplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CIplatform.service.MissionLoader;
import com.entities.City;
import com.entities.Country;
import com.entities.Mission;
import com.entities.MissionTheme;
import com.entities.Story;
import com.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class VolunteeringController {
	@Autowired
	MissionLoader service;
	
	@RequestMapping(value = "/loadRelatedMission")
	public @ResponseBody String loadRelatedMission(@RequestParam("currentMissionCity") String CMCT,@RequestParam("currentMissionTheme") String CMT,@RequestParam("currentMissionCountry") String CMCR,@RequestParam("currentMission") int CM) {
		String Output = "";
		
		Mission mission=this.service.getMissionById(CM);
		City city=this.service.getCityForRelated(CMCT);
		Country country=this.service.getCountryForRelated(CMCR);
		MissionTheme mission_theme=this.service.getThemeForRelated(CMT);
		ObjectMapper obj = new ObjectMapper();
		try {
			Output = obj.writeValueAsString(this.service.loadRelatedMissions(mission,city,country,mission_theme));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Output;
	}
	@RequestMapping(value = "/editProfile",method = RequestMethod.POST)
	public String editProfile(@RequestParam("uid") int user_id,Model m) {
		User user=this.service.getUserById(user_id);
		m.addAttribute("user",user);
		return "EditProfile";
	}
	
}
