package com.CIplatform.dao;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.CIplatform.dto.ShareStoryDto;
import com.entities.Mission;
import com.entities.MissionApplication;
import com.entities.Story;
import com.entities.StoryMedia;
import com.entities.User;
import com.entities.Story.status;

public interface StoryLoaderInterface {

	List<Story> loadAllMissionOnSearch(int currentPage);

	int loadNumberOfStoriesForPagination();

	List<MissionApplication> loadApprovedMissions(User user);

	Story loadDraft(User user, Mission mission);


	void submitStory(Mission mission, User user);

	status loadStoryStatus(Mission mission, User user);

	Story savePreviewDraft(Mission mission,
			User user);

	void saveDraft(ShareStoryDto shareStoryObject, User user, Mission mission);

	List<StoryMedia> loadDraftMedia(Story story);

}
