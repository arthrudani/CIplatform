package com.CIplatform.dao;

import java.util.List;

import com.entities.CmsPage;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.MissionTheme;
import com.entities.Story;
import com.entities.User;

public interface AdminDaoInterface {

	List<User> loadAllUsersForAdmin();

	List<Mission> loadAllMissionForAdmin();

	List<MissionTheme> loadAllThemesForAdmin();

	List<MissionApplication> loadAllApplicationForAdmin();

	List<Story> loadAllStoryForAdmin();

	List<CmsPage> loadAllCmsForAdmin();

}
