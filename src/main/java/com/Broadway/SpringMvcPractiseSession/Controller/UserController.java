package com.Broadway.SpringMvcPractiseSession.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Broadway.SpringMvcPractiseSession.Model.User;
import com.Broadway.SpringMvcPractiseSession.Service.UserService;

import lombok.extern.java.Log;

@Log
@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/home")
	public String getHome() {
		
		return "Home";
	}
	
	@GetMapping({"/","/login"})
	public String getlogin() {
		return "LoginForm";
		
	}
	
	@PostMapping("/login")
	public String getloginData(@ModelAttribute User user,Model model,HttpSession session) {
		User usr = service.userLogin(user.getUsername(), user.getPassword());
		if(usr!=null) {
			session.setAttribute("activeuser", usr);
			session.setMaxInactiveInterval(200);
			log.info("=======login success=====");
			
		}
		log.info("======login failed=====");
		model.addAttribute("error","User not found");
		return "LoginForm";
		
		
	}
	@GetMapping("/signup")
	public String getsignup() {
		return "SignupForm";
		
	}
	@PostMapping("/signup")
	public String getsignupdata(@ModelAttribute User user) {
		service.userSignup(user);
		return "LoginForm";
		
		
	}
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "LoginForm";
		
	}

}
