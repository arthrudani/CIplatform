package com.dao;

import java.util.List;

import com.dto.EditProfileObject;
import com.entities.UserSkill;
import com.entities.Skill;
import com.entities.User;

public interface EditProfileInterface {

	List<UserSkill> loadUserSkill(User user);

	void updateProfile(User user, EditProfileObject editProfileObject1);

	void changePassword(User user, String newPass);

	void updateProfilePic(User user, String profilePic);

	void updateUserSkills(User user, List<Integer> skills);


}
