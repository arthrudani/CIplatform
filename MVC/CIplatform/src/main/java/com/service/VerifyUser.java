package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entities.User;

public class VerifyUser {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		/* Get record using HQL query */
		Query query = session.createQuery("from User where email=:email and password=:password");
		query.setParameter("email", "test");
		query.setParameter("password", "test1234");
		User user = (User) query.uniqueResult();
		if (user != null) {
			System.out.println("email and password are valid");
		} else {
			System.out.println("email and password are not valid");
		}
		session.close();
	}
}