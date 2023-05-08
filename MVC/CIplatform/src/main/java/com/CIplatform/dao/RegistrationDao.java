package com.CIplatform.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.CIplatform.service.SendMailSSL;
import com.CIplatform.service.TokenGenerator;
import com.entities.Banner;
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
		user.setEmployee_id(0);
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
		
		if(password_reset!=null) {
			Date tokentime=password_reset.getCreated_at();
			Date current_time=new Date();
			if(current_time.getTime() - tokentime.getTime() > 1000000) {
				this.deletetoken(password_reset);
				return "false";
			}
			else if (password_reset != null) {
				return password_reset.getEmail();
			}
			return token;
		}
		return "false"; 
	}

	@Transactional
	public String passChanger(String password,String email) throws ClassNotFoundException, SQLException {
		Query query = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from User where email=:email");
		query.setParameter("email", email);
		User user=(User) query.uniqueResult();
		user.setPassword(password);
		this.hibernateTemplate.saveOrUpdate(user);
		
		Query query1= this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from PasswordReset where email=:email");
		query1.setParameter("email", email);
		PasswordReset password_reset = (PasswordReset) query1.uniqueResult();
		this.hibernateTemplate.delete(password_reset);
		return "true";
	}
	public List<Banner> loadAllBanner() {
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery("from Banner where (deleted_at is null) ORDER BY sortOrder");
		return query.list();
	}
}
