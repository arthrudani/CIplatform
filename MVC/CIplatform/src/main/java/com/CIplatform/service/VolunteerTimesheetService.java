package com.CIplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.CIplatform.dao.EditProfileInterface;
import com.CIplatform.dao.VolunteerTimesheetDaoInterface;
import com.CIplatform.dto.ShareTimesheetDto;
import com.entities.Mission;
import com.entities.Timesheet;
import com.entities.User;

@Service
public class VolunteerTimesheetService implements VolunteerTimesheetInterface{
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	VolunteerTimesheetDaoInterface timesheetDaoInterface;

	public List<Timesheet> loadAllMissionByTimesheet(User user) {
		return this.timesheetDaoInterface.loadAllMissionByTimesheet(user);
	}

	public void saveTimesheet(ShareTimesheetDto shareTimesheetDto) {
		this.timesheetDaoInterface.saveTimesheet(shareTimesheetDto);
	}

	public List<Mission> loadApprovedMissionsTimebased(User user) {
		return this.timesheetDaoInterface.loadApprovedMissionsTimebased(user);
	}

	public List<Mission> loadApprovedMissionsGoalbased(User user) {
		return this.timesheetDaoInterface.loadApprovedMissionsGoalbased(user);
	}
}
