package com.CIplatform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CIplatform.dto.AddCmsDto;
import com.CIplatform.dto.AddNewMissionDto;
import com.CIplatform.dto.AddNewUserDto;
import com.entities.CmsPage;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.MissionTheme;
import com.entities.Story;
import com.entities.User;

@Service
public interface AdminInterface {

	List<User> loadAllUsersForAdmin();

	void deleteUser(int uid);

	List<Mission> loadAllMissionForAdmin();

	void deleteMission(int mid);

	List<MissionTheme> loadAllThemesForAdmin();

	void deleteTheme(int themeid);

	List<MissionApplication> loadAllApplicationForAdmin();

	void approveMissionApplication(int applicationID);

	void rejectMissionApplication(int applicationID);

	List<Story> loadAllStoryForAdmin();

	void approveStoryApplication(int applicationID);

	void rejectStoryApplication(int applicationID);

	void deleteStoryApplication(int applicationID);

	List<CmsPage> loadAllCmsForAdmin();

	void deleteCms(int cmsid);

	void saveNewCms(AddCmsDto addCmsObject);

	void editCms(CmsPage cmsPage, AddCmsDto editCmsObject);

	int addNewUSer(AddNewUserDto addUserObject);

	void editUser(User user, AddNewUserDto addNewUserDto);

	void saveNewMission(AddNewMissionDto addNewMissionDto);

	void editMission(AddNewMissionDto editMissionObject);


}
