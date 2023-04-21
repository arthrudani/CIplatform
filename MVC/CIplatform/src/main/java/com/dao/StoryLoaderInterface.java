package com.dao;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dto.ShareStoryDto;
import com.entities.StoryMedia;
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


	void submitStory(mission mission, user user);

	status loadStoryStatus(mission mission, user user);

	story savePreviewDraft(mission mission,
			user user);

	void saveDraft(ShareStoryDto shareStoryObject, user user, mission mission);

	List<StoryMedia> loadDraftMedia(story story);

}
