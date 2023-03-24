package com.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.Filters;
import com.entities.city;
import com.entities.country;
import com.entities.mission;
import com.entities.mission_theme;
import com.entities.skill;
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
				List<mission> mylist = this.service.loadAllMissionOnSearch(filter);
				Output = obj.writeValueAsString(mylist);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("output:" + Output);
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

}
