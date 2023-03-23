package com.ctrl;

import java.sql.SQLException;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.LandingpageDao;
import com.dao.RegistrationDao;
import com.entities.city;
import com.entities.country;
import com.entities.mission;
import com.entities.mission_theme;
import com.entities.user;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeCtrl {

	@Autowired
	private RegistrationDao registrationDao;
	@Autowired
	private LandingpageDao landingpageDao;

	@RequestMapping("/registration")
	public String home(Model m) {
		return "registration";
	}

	@RequestMapping(path = "/savedata", method = RequestMethod.POST)
	public String myFormHandler(@ModelAttribute("user") user user, Model m) {
		this.registrationDao.save(user);
		m.addAttribute("msg" , "Successfully registered");
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
	public String homeGrid() {
		return "homeGrid";
	}

	@RequestMapping(path = "/verifyuser", method = RequestMethod.POST)
	public String myUserverifier(@RequestParam("email") String email, @RequestParam("password") String password,Model m) {
		String vr = "";
		vr = this.registrationDao.verifyuser(email, password);
		if (vr == "true") {
			
			user userdetail = this.landingpageDao.getuserdetails(email);
			m.addAttribute("first_name" , userdetail.getFirst_name());
			m.addAttribute("last_name" , userdetail.getLast_name());
			m.addAttribute("avatar" , userdetail.getAvatar());
			
			List<mission> missiondetail=this.landingpageDao.getallmission();
//			List<country> countrydetails=this.landingpageDao.getcountrydetails();
//			List<city> citydetails=this.landingpageDao.getcitydetails(userdetail.getCountry().getCountry_id());
//			List<mission_theme> missionthemedetails=this.landingpageDao.getmissionthemedetails();
			
			m.addAttribute("missionlist" ,  missiondetail);
//			m.addAttribute("countrylist" ,  countrydetails);
//			m.addAttribute("citylist" ,  citydetails);
//			m.addAttribute("missionthemelist" ,  missionthemedetails);
			m.addAttribute("usercountry" ,  userdetail.getCountry().getName());
			
			homeGrid();
			return "homeGrid";
		} else {
			m.addAttribute("msg" , "Email id or password is incorrect");
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
			System.out.println("generate new token");
			m.addAttribute("email","Please send new mail");
			return "ForgotPass";
		}
		else if (email != "") {	
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
	
//	@RequestMapping(value = "/searchMissions", method = RequestMethod.POST)
//	public @ResponseBody String searchMissions(@RequestParam("key") String key){
//		List<mission> result=this.landingpageDao.fetchmissionsbysearching(key);
//		ObjectMapper objectMapper = new ObjectMapper();
//		String json=null;
//		try {
//			 json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
//	      } catch(Exception e) {
//	         e.printStackTrace();
//	      }
//		return json;
//	}
//	
//	@RequestMapping(value = "/searchMissionsByCountry", method = RequestMethod.POST)
//	public @ResponseBody String searchMissionsByCountry(@RequestParam("key") String key){
//		int countryid=this.landingpageDao.fetchCountryIdbyCountryName(key);
//		List<mission> result=this.landingpageDao.fetchmissionsbycountry(countryid);
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		String json=null;
//		try {
//			 json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
//	      } catch(Exception e) {
//	         e.printStackTrace();
//	      }
//		return json;
//	}
//	
//	@RequestMapping(value = "/searchMissionsByCity", method = RequestMethod.POST)
//	public @ResponseBody String searchMissionsByCity(@RequestParam("key") String key){
//		int cityid=this.landingpageDao.fetchCountryIdbyCityName(key);
//		List<mission> result=this.landingpageDao.fetchmissionsbycity(cityid);
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		String json=null;
//		try {
//			 json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
//	      } catch(Exception e) {
//	         e.printStackTrace();
//	      }
//		return json;
//	}
//	
}
