package com.CIplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.CIplatform.dto.ShareTimesheetDto;
import com.CIplatform.service.EditProfile;
import com.CIplatform.service.MissionLoader;
import com.CIplatform.service.VolunteerTimesheetInterface;
import com.entities.Mission;
import com.entities.Timesheet;
import com.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class VolunteerTimesheetController {
	@Autowired
	VolunteerTimesheetInterface service;
	
	@Autowired
	MissionLoader service1;
	
	@RequestMapping(value = "/loadApprovedMissionsTimebased")
	public @ResponseBody String loadApprovedMissionsTimebased(@RequestParam("user_id") int user_id) {
		User user=this.service1.getUserById(user_id);
		List<Mission> mylist = this.service.loadApprovedMissionsTimebased(user);
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
	@RequestMapping(value = "/loadApprovedMissionsGoalbased")
	public @ResponseBody String loadApprovedMissionsGoalbased(@RequestParam("user_id") int user_id) {
		User user=this.service1.getUserById(user_id);
		List<Mission> mylist = this.service.loadApprovedMissionsGoalbased(user);
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
	
	@RequestMapping(value = "/volunteeringTimesheet")
	public String volunteeringTimesheet(@RequestParam("uid") int user_id,Model m) {
		User user=this.service1.getUserById(user_id);
		m.addAttribute("user",user);
		return "VolunteeringTimesheet";
	}
	
	@RequestMapping(value = "/loadTimesheetsByUser")
	public @ResponseBody List<Timesheet> loadTimesheetsByUser(@RequestParam("user_id") int user_id) {
		User user=this.service1.getUserById(user_id);
		List<Timesheet> mylist = this.service.loadAllMissionByTimesheet(user);
		return mylist;
	}
	
	@RequestMapping(value = "/saveTimesheet",method = RequestMethod.POST)
	public @ResponseBody String saveTimesheet(ShareTimesheetDto shareTimesheetDto) {
		this.service.saveTimesheet(shareTimesheetDto);
		return "true";
	}
	@RequestMapping(value = "/deleteTimesheet",method = RequestMethod.POST)
	public @ResponseBody String deleteTimesheet(@RequestParam("timesheetId") int tid) {
		this.service.deleteTimesheet(tid);
		return "true";
	}
	
}
