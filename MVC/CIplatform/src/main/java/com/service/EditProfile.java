package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.EditProfileObject;
import com.entities.UserSkill;
import com.entities.skill;
import com.entities.user;

@Service
public interface EditProfile {

	List<skill> loadAllSkill();

	List<UserSkill> loadUserSkill(user user);

	void updateProfile(user user, EditProfileObject editProfileobj);

	boolean validateOldPass(user user, String oldPass, String newPass);

	void changePassword(user user, String newPass);

}
