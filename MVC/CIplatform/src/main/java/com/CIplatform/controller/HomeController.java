package com.CIplatform.controller;

import java.sql.SQLException;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CIplatform.dao.LandingpageDao;
import com.CIplatform.dao.RegistrationDao;
import com.entities.Banner;
import com.entities.City;
import com.entities.Country;
import com.entities.Mission;
import com.entities.MissionTheme;
import com.entities.User;
import com.entities.User.type;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

	@Autowired
	private RegistrationDao registrationDao;
	@Autowired
	private LandingpageDao landingpageDao;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@RequestMapping("/registration")
	public String home(Model m) {
		return "registration";
	}

	@RequestMapping(path = "/savedata", method = RequestMethod.POST)
	public String myFormHandler(@ModelAttribute("user") User user, Model m) {
		int i=this.registrationDao.save(user);
		if(i==0) {
			m.addAttribute("msg" , "Email already exists");
		}
		else {
			m.addAttribute("msg" , "Successfully registered");
		}
		
		return "registration";
	}

	@RequestMapping(path = "/login")
	public String mylogin() {
		return "login";
	}

	@RequestMapping(path = "/ForgotPass")
	public String myForgotPass() {
		return "ForgotPass";
	}

	@RequestMapping(path = "/homeGrid")
	public String homeGrid(HttpSession session) {
		User user=(User)session.getAttribute("user");
		if(user!=null) {
			System.out.println(user.getUser_id());
			return "homeGrid";
		}
		return "login";
	}

	@RequestMapping(path = "/verifyuser", method = RequestMethod.POST)
	public String myUserverifier(@RequestParam("email") String email, @RequestParam("password") String password,Model m,HttpServletRequest request) {
		
		String vr = "";
		vr = this.registrationDao.verifyuser(email, password);
		if (vr == "true") {
			
			User userdetail = this.landingpageDao.getuserdetails(email);
			request.getSession(true).setAttribute("user",userdetail);
			m.addAttribute("user" , userdetail);
			m.addAttribute("first_name" , userdetail.getFirst_name());
			m.addAttribute("user_id" , userdetail.getUser_id());
			m.addAttribute("last_name" , userdetail.getLast_name());
			m.addAttribute("avatar" , userdetail.getAvatar());
			
			List<Mission> missiondetail=this.landingpageDao.getallmission();
			m.addAttribute("missionlist" ,  missiondetail);
			m.addAttribute("usercountry" ,  userdetail.getCountry().getName());
			if(userdetail.getType()==type.VOLUNTEER) {
				return "homeGrid";
			}
			else {
				return "AdminUser";
			}
		}
		else {
			m.addAttribute("msg","Email id or password is incorrect");
			return "login";
		}
	}
	 

	@RequestMapping(path = "/ForgotPassword", method = RequestMethod.POST)
	public String myResetPass(@RequestParam("email") String email,Model m) {
		String vremail = "";
		vremail = this.registrationDao.ResetPass(email);
		if (vremail != "false") {
			m.addAttribute("msg" , "Email sent to your registered email");
		} else {
			m.addAttribute("msg" , "Email does not exist in database");
		}
		return "ForgotPass";
	}

	@RequestMapping(path = "/ResetPassword/{token}")
	public String myResetPassword(@PathVariable("token") String token,Model m) {
		System.out.println(token);
		
		String email=this.registrationDao.tokencheck(token);
		
		if (email == "false") {	
			m.addAttribute("email","Please send new mail");
			return "ForgotPass";
		}
		else if (email != "") {
			m.addAttribute("email",email);
			return "ResetPassword";
		} else {
			return "ForgotPass";
		}
	}

	@RequestMapping(value = "/passwordReset", method = RequestMethod.POST)
	public String passwordResetter(@RequestParam("password") String password,@RequestParam("email") String email) throws ClassNotFoundException, SQLException {
		this.registrationDao.passChanger(password,email);
		return "login";
	}
	@RequestMapping(value = "/loadAllBanner")
	public @ResponseBody List<Banner> loadAllBanner() {
		return this.registrationDao.loadAllBanner();
	}
	
	@RequestMapping(value = "/PrivacyPolicy")
	public String PrivacyPolicy(@RequestParam("uid") int uid,Model m) {
		User user=this.hibernateTemplate.get(User.class, uid);
		m.addAttribute("user",user);
		return "PrivacyPolicy";
	}
}
