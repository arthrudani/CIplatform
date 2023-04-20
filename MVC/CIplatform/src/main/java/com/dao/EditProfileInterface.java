package com.dao;

import java.util.List;

import com.dto.EditProfileObject;
import com.entities.UserSkill;
import com.entities.skill;
import com.entities.user;

public interface EditProfileInterface {

	List<UserSkill> loadUserSkill(user user);

	void updateProfile(user user, EditProfileObject editProfileObject1);


}
