package com.Broadway.SpringMvcPractiseSession.Controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
	@GetMapping("/gallery")
	public String getgallery(Model model,HttpSession session) {
		   if(session.getAttribute("activeuser") ==null) {
			   return "LoginForm";
		   }
		
		   String[] imgNames=new File("src/main/resources/static/Image").list();
		   model.addAttribute("imgNameslist",imgNames);
		
		
		 return "GalleryForm";
		
	}

}
