package com.CIplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.CIplatform.dao.EditProfileInterface;
import com.CIplatform.dao.StoryLoaderInterface;
import com.entities.Skill;
import com.entities.User;
import com.entities.UserSkill;
@Service
public class EditProfileService implements EditProfile{
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	EditProfileInterface editProfileInterface;

	public List<Skill> loadAllSkill() {
		return this.hibernateTemplate.loadAll(Skill.class);
	}

	public List<UserSkill> loadUserSkill(User user) {
		return this.editProfileInterface.loadUserSkill(user);
	}

	public void updateProfile(User user, com.CIplatform.dto.EditProfileObject editProfileObject1) {
		
		this.editProfileInterface.updateProfile(user,editProfileObject1);
	}

	public boolean validateOldPass(User user, String oldPass,String newPass) {
		
		if(user.getPassword().equals(oldPass)) {
			return true;
		}
		else{
			return false;
		}
	}

	public void changePassword(User user, String newPass) {
		this.editProfileInterface.changePassword(user,newPass);
	}

	public void updateProfilePic(User user, String profilePic) {
		this.editProfileInterface.updateProfilePic(user,profilePic);
	}

	public void updateUserSkills(User user, List<Integer> skills) {
		this.editProfileInterface.updateUserSkills(user,skills);
		
	}

	


}
