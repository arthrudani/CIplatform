package com.CIplatform.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.City;
import com.entities.Country;
import com.entities.Mission;
import com.entities.MissionTheme;
import com.entities.User;

@Component
public class LandingpageDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public User getuserdetails(String email) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from User where email=:email");
		query.setParameter("email", email);
		return (User) query.uniqueResult();
	}

	public List<Mission> getallmission() {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from Mission");
		return query.list();
	}

}
