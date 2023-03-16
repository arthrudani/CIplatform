package com.ctrl;

import java.sql.SQLException;

//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.RegistrationDao;
import com.entities.password_reset;
import com.entities.user;

@Controller
public class HomeCtrl {

	@Autowired
	private RegistrationDao registrationDao;

	@RequestMapping("/registration")
	public String home(Model m) {
		return "registration";
	}

	@RequestMapping(path = "/savedata", method = RequestMethod.POST)
	public String myFormHandler(@ModelAttribute("user") user user, Model m) {
		this.registrationDao.save(user);
		return "homeGrid";
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
	public String homeGrid() {
		return "homeGrid";
	}

	@RequestMapping(path = "/homeList")
	public String homeList() {
		return "homeList";
	}

	@RequestMapping(path = "/verifyuser", method = RequestMethod.POST)
	public String myUserverifier(@RequestParam("email") String email, @RequestParam("password") String password) {
		String vr = "";
		vr = this.registrationDao.verifyuser(email, password);
		System.out.println(vr);

		if (vr == "true") {
			return "homeGrid";
		} else {
			return "login";
		}
	}

	@RequestMapping(path = "/ForgotPassword", method = RequestMethod.POST)
	public String myResetPass(@RequestParam("email") String email) {
		String vremail = "";
		vremail = this.registrationDao.ResetPass(email);
		if (vremail != "false") {
			System.out.println("email exists in database");
		} else {
			System.out.println("email does not exists in database");
		}
		return "";
	}

	@RequestMapping(path = "/ResetPassword/{token}")
	public String myResetPassword(@PathVariable("token") String token,Model m) {
		System.out.println(token);
		String email=this.registrationDao.tokencheck(token);
		if (email != "") {	
			System.out.println("email and token exists in database");
			m.addAttribute("email",email);
			return "ResetPassword";
		} else {
			System.out.println(token);
			System.out.println("email and token does not exists in database");
			return "ForgotPass";
		}
	}

	@RequestMapping(value = "/passwordReset", method = RequestMethod.POST)
	public String passwordResetter(@RequestParam("password") String password,@RequestParam("email") String email) throws ClassNotFoundException, SQLException {
		this.registrationDao.passChanger(password,email);
		return "login";
	}
}
