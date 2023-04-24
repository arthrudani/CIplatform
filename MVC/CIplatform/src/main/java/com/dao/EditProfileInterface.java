package com.dao;

import java.util.List;

import com.dto.EditProfileObject;
import com.entities.UserSkill;
import com.entities.skill;
import com.entities.user;

public interface EditProfileInterface {

	List<UserSkill> loadUserSkill(user user);

	void updateProfile(user user, EditProfileObject editProfileObject1);

	void changePassword(user user, String newPass);

	void updateProfilePic(user user, String profilePic);

	void updateUserSkills(user user, List<Integer> skills);


}
