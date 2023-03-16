package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entities.user;

public class verifyuser {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		/* Get record using HQL query */
		Query query = session.createQuery("from user where email=:email and password=:password");
		query.setParameter("email", "test");
		query.setParameter("password", "test1234");
		user user = (user) query.uniqueResult();
		if (user != null) {
			System.out.println("email and password are valid");
		} else {
			System.out.println("email and password are not valid");
		}
		session.close();
	}
}