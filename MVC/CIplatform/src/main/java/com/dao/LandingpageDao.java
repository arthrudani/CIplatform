package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.city;
import com.entities.country;
import com.entities.mission;
import com.entities.mission_theme;
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

//	public List<mission> fetchmissionsbysearching(String key) {
//		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from mission where title like :key ");
//		query.setParameter("key","%" + key + "%"); 
////		Query query1 = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from mission where description like :key ");
////		query1.setParameter("key","%" + key + "%"); 
////		query.list().add(query1);
//		query.list();
//		return query.list();
//	}
//	
//	public List<mission> fetchmissionsbycountry(int key) {
//		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from mission where country_id=:country_id ");
//		query.setParameter("country_id",key);
//		query.list();
//		return query.list();
//	}
//
//	
//
//	public int fetchCountryIdbyCountryName(String key) {
//		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from country where name=:name ");
//		query.setParameter("name",key);
//		country result = (country) query.uniqueResult();
//		return result.getCountry_id();
//	}
//	
//	public List<mission> fetchmissionsbycity(int key) {
//		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from mission where city_id=:city_id ");
//		query.setParameter("city_id",key);
//		query.list();
//		return query.list();
//	}
//
//	
//
//	public int fetchCountryIdbyCityName(String key) {
//		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from city where name=:name ");
//		query.setParameter("name",key);
//		city result = (city) query.uniqueResult();
//		return result.getCity_id();
//	}
//	
//	
//	public List<country> getcountrydetails() {
//		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from country");
//		return query.list();
//	}
//
//	public List<city> getcitydetails(int country_id) {
//		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from city where country_id=:country_id");
//		query.setParameter("country_id", country_id);
//		return query.list();
//	}
//
//	public List<mission_theme> getmissionthemedetails() {
//		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from mission_theme");
//		return query.list();
//	}
//
//

}
