package com.Broadway.SpringMvcPractiseSession.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Broadway.SpringMvcPractiseSession.utils.Mailutil;

@Controller
public class EmailController {
	
	@Autowired
	private Mailutil mailutil;
	
	@GetMapping("/contact")
	public String getContact(HttpSession session) {
		
		
		
	
		
		return "EmailForm";
		
	}
	
	@PostMapping("/contact")
	public String postContact(@RequestParam String To_email,@RequestParam String subject,@RequestParam String message) {
		
		mailutil.sendEmail(To_email,subject,message);
		return "EmailForm";
		
	}

}
