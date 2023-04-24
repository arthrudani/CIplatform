package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.dao.EditProfileInterface;
import com.dao.StoryLoaderInterface;
import com.entities.UserSkill;
import com.entities.skill;
import com.entities.user;
@Service
public class EditProfileService implements EditProfile{
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	EditProfileInterface editProfileInterface;

	public List<skill> loadAllSkill() {
		return this.hibernateTemplate.loadAll(skill.class);
	}

	public List<UserSkill> loadUserSkill(user user) {
		return this.editProfileInterface.loadUserSkill(user);
	}

	public void updateProfile(user user, com.dto.EditProfileObject editProfileObject1) {
		
		this.editProfileInterface.updateProfile(user,editProfileObject1);
	}

	public boolean validateOldPass(user user, String oldPass,String newPass) {
		
		if(user.getPassword().equals(oldPass)) {
			return true;
		}
		else{
			return false;
		}
	}

	public void changePassword(user user, String newPass) {
		this.editProfileInterface.changePassword(user,newPass);
	}

	public void updateProfilePic(user user, String profilePic) {
		this.editProfileInterface.updateProfilePic(user,profilePic);
	}

	public void updateUserSkills(user user, List<Integer> skills) {
		this.editProfileInterface.updateUserSkills(user,skills);
		
	}

	


}
