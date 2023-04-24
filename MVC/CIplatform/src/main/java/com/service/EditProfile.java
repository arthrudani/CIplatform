package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.EditProfileObject;
import com.entities.UserSkill;
import com.entities.Skill;
import com.entities.User;

@Service
public interface EditProfile {

	List<Skill> loadAllSkill();

	List<UserSkill> loadUserSkill(User user);

	void updateProfile(User user, EditProfileObject editProfileobj);

	boolean validateOldPass(User user, String oldPass, String newPass);

	void changePassword(User user, String newPass);

	void updateProfilePic(User user, String profilePic);

	void updateUserSkills(User user, List<Integer> skills);

}
