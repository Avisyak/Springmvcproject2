package com.Broadway.SpringMvcPractiseSession.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
    @GetMapping("/upload")
	public String getUpload(HttpSession session) {
    	if(session.getAttribute("activeuser") ==null) {
			   return "LoginForm";
		   }
    	
    	return "Upload";
		
	}
    @PostMapping("/upload")
    public String postSaveImage(@RequestParam MultipartFile image,Model model ) {
    	
    	if(!image.isEmpty()) {
    		try {
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/Image/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				model.addAttribute("message","upload success");
				return "Upload";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	model.addAttribute("message","upload failed");
		return "Upload";
    }
}
