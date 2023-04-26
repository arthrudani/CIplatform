package com.CIplatform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CIplatform.dto.ShareTimesheetDto;
import com.entities.Mission;
import com.entities.Timesheet;
import com.entities.User;

@Service
public interface VolunteerTimesheetInterface {

	List<Timesheet> loadAllMissionByTimesheet(User user);

	void saveTimesheet(ShareTimesheetDto shareTimesheetDto);

	List<Mission> loadApprovedMissionsTimebased(User user);

	List<Mission> loadApprovedMissionsGoalbased(User user);

}
