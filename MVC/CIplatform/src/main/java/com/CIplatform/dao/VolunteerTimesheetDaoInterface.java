package com.CIplatform.dao;

import java.util.List;

import com.CIplatform.dto.ShareTimesheetDto;
import com.entities.Mission;
import com.entities.Timesheet;
import com.entities.User;

public interface VolunteerTimesheetDaoInterface {

	List<Timesheet> loadAllMissionByTimesheet(User user);

	void saveTimesheet(ShareTimesheetDto shareTimesheetDto);

	List<Mission> loadApprovedMissionsTimebased(User user);

	List<Mission> loadApprovedMissionsGoalbased(User user);

}
