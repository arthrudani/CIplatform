package com.CIplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.EditProfileObject;
import com.dto.Filters;
import com.entities.UserSkill;
import com.entities.skill;
import com.entities.user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.EditProfile;
import com.service.missionLoader;
@Controller
public class EditProfileController {
	@Autowired
	EditProfile service;
	
	@Autowired
	missionLoader service1;
	
	@RequestMapping(value = "/loadAllSkill")
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
	@RequestMapping(value = "/loadUserSkill")
	public @ResponseBody String loadUserSkill(@RequestParam("uid") int user_id) {
		user user=this.service1.getUserById(user_id);
		List<UserSkill> mylist = this.service.loadUserSkill(user);
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
	@RequestMapping(value = "/loadAllDetails")
	public @ResponseBody String loadAllDetails(@RequestParam("uid") int user_id) {
		user user=this.service1.getUserById(user_id);
		ObjectMapper obj = new ObjectMapper();
		String Output = "";
		try {
			Output = obj.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Output;
	}
	@RequestMapping(value = "/updateProfile")
	public @ResponseBody String updateProfile(@RequestParam("uid") int user_id,@RequestParam("EditProfile") String EditProfileObject) throws JsonMappingException {
		user user=this.service1.getUserById(user_id);
		
		String Output = "";
		ObjectMapper obj = new ObjectMapper();
		
		try {
			EditProfileObject editProfileobj = obj.readValue(EditProfileObject, EditProfileObject.class);
			this.service.updateProfile(user, editProfileobj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EditProfileObject;	
	}
}
