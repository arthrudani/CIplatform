package com.CIplatform.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.EditProfileObject;
import com.dto.Filters;
import com.entities.UserSkill;
import com.entities.Skill;
import com.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.EditProfile;
import com.service.MissionLoader;
@Controller
public class EditProfileController {
	@Autowired
	EditProfile service;
	
	@Autowired
	MissionLoader service1;
	
	@RequestMapping(value = "/loadAllSkill")
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
	@RequestMapping(value = "/loadUserSkill")
	public @ResponseBody String loadUserSkill(@RequestParam("uid") int user_id) {
		User user=this.service1.getUserById(user_id);
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
		User user=this.service1.getUserById(user_id);
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
	public @ResponseBody String updateProfile(@RequestParam("uid") int user_id,@RequestParam("EditProfile") String EditProfileObject) {
		User user=this.service1.getUserById(user_id);
		
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
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public @ResponseBody int changePassword(@RequestParam("uid") int user_id,@RequestParam("oldPass") String oldPass,@RequestParam("newPass") String newPass) {
		User user=this.service1.getUserById(user_id);
		if(this.service.validateOldPass(user,oldPass,newPass)) {
			this.service.changePassword(user,newPass);
			return 1;
		}
		else {
			return 0;
		}
	}
	@RequestMapping(value = "/updateProfilePic")
	public @ResponseBody String updateProfilePic(@RequestParam("uid") int user_id,@RequestParam("profilePic") String profilePic) {
		User user=this.service1.getUserById(user_id);
		this.service.updateProfilePic(user, profilePic);
		return "true";
	}
	@RequestMapping(value = "/updateUserSkills")
	public @ResponseBody String updateUserSkills(@RequestParam("uid") int user_id,@RequestParam("skills[]") List<Integer> skills) {
		User user=this.service1.getUserById(user_id);
		this.service.updateUserSkills(user, skills);
		return "true";
	}
	
	
}
