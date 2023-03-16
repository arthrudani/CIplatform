package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.entities.user;
import com.service.SendMailSSL;
import com.service.TokenGenerator;
import com.entities.country;
import com.entities.password_reset;

@Component
public class RegistrationDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int save(user user) {
		Integer i=(Integer) this.hibernateTemplate.save(user);
		return i;
	}
	

	
	@Transactional
	public int savecountry(country country) {
		int i=(Integer) this.hibernateTemplate.save(country);
		return i;
	}

	public String verifyuser(String email, String password) {
		SessionFactory sessionFactory=this.hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		/* Get record using HQL query */

		Query query = session.createQuery("from user where email=:email and password=:password");
		String result="";
		query.setParameter("email", email);
		query.setParameter("password", password);
		user user1 = (user) query.uniqueResult();
		if (user1 != null) {
			System.out.println("email and password are valid");
			result="true";
		} else {
			System.out.println("email and password are not valid");
			result="false";
		}
		session.close();
		return result;
	}

	@Transactional
	public String ResetPass(String email) {
		SessionFactory sessionFactory=this.hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		/* Get record using HQL query */
		Query query = session.createQuery("from user where email=:email");
		String result1="";
		query.setParameter("email", email);
		user user1 = (user) query.uniqueResult();
		if (user1 != null) {
			String token = TokenGenerator.generateToken();
			
			password_reset psrt=new password_reset();
			psrt.setEmail(email);
			psrt.setToken(token);
			psrt.setCreated_at(new Date());
			this.savePass(psrt);
			
			SendMailSSL.send("arthrudanitatvasoft@gmail.com", "unydsjatgfbcbawb", email, "Password reset link","http://localhost:8080/CIplatform/ResetPassword/"+token);
			result1=token; 
		} else {
			System.out.println("email is not valid");
			result1="false";
		}
		session.close();
		return result1;
	}

	@Transactional
	public void savePass(password_reset password_reset) {
		this.hibernateTemplate.saveOrUpdate(password_reset);
	}



	public String tokencheck(String token) {
		SessionFactory sessionFactory=this.hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		/* Get record using HQL query */

		Query query = session.createQuery("from password_reset where token=:token");
		query.setParameter("token", token);
		password_reset password_reset = (password_reset) query.uniqueResult();
		if (password_reset != null) {
			return password_reset.getEmail();
		} else {
			return "";
		}
	}

	public String passChanger(String password,String email) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
        //creating connection
        String url="jdbc:mysql://localhost:3306/ciplatform";
        String username="root";
        String password1="ZXcv!@34";
        Connection con=DriverManager.getConnection(url,username,password1);
		String q="update user set password=? where email=?";
		PreparedStatement pstmt=con.prepareStatement(q);
		pstmt.setString(1,password);
        pstmt.setString(2,email);
        pstmt.executeUpdate();

        System.out.println("Updated...");

        con.close();
		
		return "true";
	}
}
