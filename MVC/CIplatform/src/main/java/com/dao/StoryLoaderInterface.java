package com.dao;

import java.util.Date;
import java.util.List;

import com.entities.mission;
import com.entities.mission_application;
import com.entities.story;
import com.entities.story.status;
import com.entities.user;

public interface StoryLoaderInterface {

	List<story> loadAllMissionOnSearch(int currentPage);

	int loadNumberOfStoriesForPagination();

	List<mission_application> loadApprovedMissions(user user);

	story loadDraft(user user, mission mission);

	void saveDraft(String storyTitle, Date storyDate, String description, String videoURL, mission mission, user user,status status);

	void submitStory(mission mission, user user);

	status loadStoryStatus(mission mission, user user);

}
