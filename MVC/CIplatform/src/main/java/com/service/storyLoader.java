package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dto.ShareStoryDto;
import com.entities.StoryMedia;
import com.entities.mission;
import com.entities.mission_application;
import com.entities.story;
import com.entities.story.status;
import com.entities.user;

@Service
public interface storyLoader {

	List<story> loadAllStories(int currentPage);

	int loadNumberOfStoriesForPagination();

	List<mission_application> loadApprovedMissions(user user);

	story loadDraft(user user, mission mission);

	void submitStory(mission mission, user user);

	status loadStoryStatus(mission mission, user user);

	story savePreviewDraft(mission mission,
			user user);

	String recommendToCoWorker(mission mission, String email, user user);


	void saveDraft(ShareStoryDto shareStoryObject, user user, mission mission);

	List<StoryMedia> loadDraftMediaOfStory(story story);

}
