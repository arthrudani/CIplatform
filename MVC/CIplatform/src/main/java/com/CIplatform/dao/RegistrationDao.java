package com.CIplatform.dao;

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

import com.CIplatform.service.SendMailSSL;
import com.CIplatform.service.TokenGenerator;
import com.entities.Country;
import com.entities.PasswordReset;
import com.entities.User;
import com.entities.User.Status;
import com.entities.User.type;

@Component
public class RegistrationDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int save(User user) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from User where email=:email");
		query.setParameter("email", user.getEmail());
		User user1 = (User) query.uniqueResult();
		if (user1 != null) {
			return 0;
		}
		user.setType(type.VOLUNTEER);
		user.setStatus(Status.ACTIVE);
		user.setAvatar("noImageFound.png");
		Integer i=(Integer) this.hibernateTemplate.save(user);
		return i;
	}
	@Transactional
	public int savecountry(Country country) {
		int i=(Integer) this.hibernateTemplate.save(country);
		return i;
	}

	public String verifyuser(String email, String password) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from User where email=:email and password=:password and (deleted_at is null)");
		String result="";
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user1 = (User) query.uniqueResult();
		if (user1 != null) {
			result="true";
		} else {
			result="false";
		}
		return result;
	}

	@Transactional
	public String ResetPass(String email) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from User where email=:email");
		String result1="";
		query.setParameter("email", email);
		User user1 = (User) query.uniqueResult();
		if (user1 != null) {
			String token = TokenGenerator.generateToken();
			PasswordReset psrt=new PasswordReset();
			psrt.setEmail(email);
			psrt.setToken(token);
			psrt.setCreated_at(new Date());
			this.savePass(psrt);

			SendMailSSL.send("arthrudanitatvasoft@gmail.com", "unydsjatgfbcbawb", email, "Password reset link","http://localhost:8080/CIplatform/ResetPassword/"+token);
			result1=token; 
		} else {
			result1="false";
		}
		return result1;
	}

	@Transactional
	public void savePass(PasswordReset password_reset) {
		this.hibernateTemplate.saveOrUpdate(password_reset);
	}
	
	@Transactional
	public void deletetoken(PasswordReset password_reset) {
		this.hibernateTemplate.delete(password_reset);
	}


	@Transactional
	public String tokencheck(String token) {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from PasswordReset where token=:token");
		query.setParameter("token", token);
		PasswordReset password_reset = (PasswordReset) query.uniqueResult();
		Date tokentime=password_reset.getCreated_at();
		System.out.println("old token created at : "+ password_reset.getCreated_at());
		Date current_time=new Date();
		System.out.println("current time : "+current_time);
		if(current_time.getTime() - tokentime.getTime() > 1000000) {
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

        String q1="delete from PasswordReset where email=?";
		PreparedStatement pstmt1=con.prepareStatement(q1);
        pstmt1.setString(1,email);
        pstmt1.executeUpdate();
        
        con.close();
		
		return "true";
	}
}
