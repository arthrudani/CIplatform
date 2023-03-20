package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Query;
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
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from user where email=:email and password=:password");
		String result="";
		query.setParameter("email", email);
		query.setParameter("password", password);
		user user1 = (user) query.uniqueResult();
		if (user1 != null) {
			result="true";
		} else {
			result="false";
		}
		return result;
	}

	@Transactional
	public String ResetPass(String email) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from user where email=:email");
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
		return result1;
	}

	@Transactional
	public void savePass(password_reset password_reset) {
		this.hibernateTemplate.saveOrUpdate(password_reset);
	}
	
	@Transactional
	public void deletetoken(password_reset password_reset) {
		this.hibernateTemplate.delete(password_reset);
	}


	@Transactional
	public String tokencheck(String token) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from password_reset where token=:token");
		query.setParameter("token", token);
		password_reset password_reset = (password_reset) query.uniqueResult();
		Date tokentime=password_reset.getCreated_at();
		System.out.println("old token created at : "+ password_reset.getCreated_at());
		Date current_time=new Date();
		System.out.println("current time : "+current_time);
		if(current_time.getTime() - tokentime.getTime() > 20000) {
			this.deletetoken(password_reset);
			System.out.println("Token deleted");
			return "false";
		}
		else if (password_reset != null) {
			System.out.println("Token not deleted and valid");
			return password_reset.getEmail();
		}
		return token; 
	}

	@Transactional
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

        String q1="delete from password_reset where email=?";
		PreparedStatement pstmt1=con.prepareStatement(q1);
        pstmt1.setString(1,email);
        pstmt1.executeUpdate();
        
        con.close();
		
		return "true";
	}
}
