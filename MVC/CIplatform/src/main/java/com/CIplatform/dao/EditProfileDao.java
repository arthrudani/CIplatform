package com.CIplatform.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.CIplatform.dto.EditProfileObject;
import com.entities.City;
import com.entities.Country;
import com.entities.Skill;
import com.entities.User;
import com.entities.UserSkill;

@Component
public class EditProfileDao  implements EditProfileInterface{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<UserSkill> loadUserSkill(User user) {
		String que = "from UserSkill where user=:user";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user", user);
		List<UserSkill> mylist = q.list();
		return mylist;
	}

	@Transactional
	public void updateProfile(User user,EditProfileObject editProfileObject1) {
		String que = "from User where user_id=:user_id";
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que);
		q.setParameter("user_id", user.getUser_id());
		User user1 = (User) q.uniqueResult();
//		user1.setAvatar(que);
		if(editProfileObject1.getDepartment()!="") {
			user1.setDepartment(editProfileObject1.getDepartment());
		}
		if(editProfileObject1.getName()!="") {
			user1.setFirst_name(editProfileObject1.getName());
		}
		if(editProfileObject1.getSurname()!="") {
			user1.setLast_name(editProfileObject1.getSurname());
		}
		if(editProfileObject1.getLinkedInUrl()!="") {
			user1.setLinked_in_url(editProfileObject1.getLinkedInUrl());
		}
		if(editProfileObject1.getTitle()!="") {
			user1.setTitle(editProfileObject1.getTitle());
		}
		if(editProfileObject1.getWhyIVolunteer()!="") {
			user1.setWhy_i_volunteer(editProfileObject1.getWhyIVolunteer());
		}
		if(editProfileObject1.getCity()!=null) {
			City city=this.hibernateTemplate.get(City.class,Integer.parseInt(editProfileObject1.getCity()));
			user1.setCity(city);
		}
		if(editProfileObject1.getCountry()!=null) {
			Country country=this.hibernateTemplate.get(Country.class,Integer.parseInt(editProfileObject1.getCountry()));
			user1.setCountry(country);
		}
		if(editProfileObject1.getSkills()!=null) {
			System.out.println(editProfileObject1.getSkills());
		}
		
		this.hibernateTemplate.saveOrUpdate(user1);
	}

	@Transactional
	public void changePassword(User user, String newPass) {
		String que = "from User where user_id=:user_id";
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que);
		q.setParameter("user_id", user.getUser_id());
		User user1 = (User) q.uniqueResult();
		user1.setPassword(newPass);
		this.hibernateTemplate.saveOrUpdate(user1);
	}
	
	@Transactional
	public void updateProfilePic(User user, String profilePic) {
		String que = "from User where user_id=:user_id";
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que);
		q.setParameter("user_id", user.getUser_id());
		User user1 = (User) q.uniqueResult();
		user1.setAvatar(profilePic);
		this.hibernateTemplate.saveOrUpdate(user1);
	}

	@Transactional
	public void updateUserSkills(User user1, List<Integer> skills) {
		
		String que1 = "delete from UserSkill where user_id=:user_id";
		Query q1 = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(que1);
		q1.setParameter("user_id", user1.getUser_id());
		q1.executeUpdate();
		
		System.out.println(skills);
		for(int i=0;i<skills.size();i++) {
			Skill skill=this.hibernateTemplate.get(Skill.class,skills.get(i));
			UserSkill UserSkill2=new UserSkill();
			UserSkill2.setCreatedAt(new Date());
			UserSkill2.setSkill(skill);
			UserSkill2.setUser(user1);
			this.hibernateTemplate.save(UserSkill2);
		}
	}
}
