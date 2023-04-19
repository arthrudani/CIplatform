package com.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.city;
import com.entities.country;
import com.entities.mission;
import com.entities.mission_theme;
import com.entities.story;
import com.entities.user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.missionLoader;

@Controller
public class VolunteeringController {
	@Autowired
	missionLoader service;
	
	@RequestMapping(value = "/loadRelatedMission")
	public @ResponseBody String loadRelatedMission(@RequestParam("currentMissionCity") String CMCT,@RequestParam("currentMissionTheme") String CMT,@RequestParam("currentMissionCountry") String CMCR,@RequestParam("currentMission") int CM) {
		String Output = "";
		
		mission mission=this.service.getMissionById(CM);
		city city=this.service.getCityForRelated(CMCT);
		country country=this.service.getCountryForRelated(CMCR);
		mission_theme mission_theme=this.service.getThemeForRelated(CMT);
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
		user user=this.service.getUserById(user_id);
		m.addAttribute("user",user);
		return "EditProfile";
	}
	
}
