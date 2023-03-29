package com.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.city;
import com.entities.country;
import com.entities.mission;
import com.entities.mission_theme;
import com.entities.user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.missionLoader;

@Controller
public class VolunteeringController {
	@Autowired
	missionLoader service;
	
	@RequestMapping(value = "/loadRelatedMission")
	public @ResponseBody String loadRelatedMission(@RequestParam("currentMissionCity") String CMCT,@RequestParam("currentMissionTheme") String CMT,@RequestParam("currentMissionCountry") String CMCR) {
		String Output = "";
		city city=this.service.getCityForRelated(CMCT);
		country country=this.service.getCountryForRelated(CMCR);
		mission_theme mission_theme=this.service.getThemeForRelated(CMT);
		ObjectMapper obj = new ObjectMapper();
		try {
			Output = obj.writeValueAsString(this.service.loadRelatedMissions(CMCT,CMCR,CMT));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("final:"+Output);
		
		return Output;
	}
}