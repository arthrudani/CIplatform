package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.mission;
import com.entities.user;


@Component
public class LandingpageDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public user getuserdetails(String email) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from user where email=:email");
		query.setParameter("email", email);
		return (user) query.uniqueResult();
	}

	public List<mission> getallmission() {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from mission");
		return query.list();
	}
}
