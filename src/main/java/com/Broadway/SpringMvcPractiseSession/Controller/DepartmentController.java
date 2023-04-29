package com.Broadway.SpringMvcPractiseSession.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Broadway.SpringMvcPractiseSession.Model.Department;
import com.Broadway.SpringMvcPractiseSession.Service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService depService;
	
	@GetMapping("/department")
	public String getDept(HttpSession session) {
		if(session.getAttribute("activeuser") ==null) {
			   return "LoginForm";
		   }
		return "AddDepartment";
		
	}
	@PostMapping("/department")
	public String postDept(@ModelAttribute Department department) {
		
		depService.addDepartment(department);
		return "AddDepartment";
		
	}
	@GetMapping("/departmentlist")
	public String getAll(Model model) {
		model.addAttribute("dlist",depService.getDepartment());
		
		return "ListDepartment";
		
	}
	
	@GetMapping("/edit")
	public String editDept(@RequestParam int id,Model model) {
		model.addAttribute("deptmodel", depService.getDepartmentByID(id));
		
		return "EditDepartment";
	}
	@PostMapping("/update")
	public String updateDept(@ModelAttribute Department dept) {
		depService.addDepartment(dept);
		
		return "redirect:/departmentlist";
		
	}
	
	
	

}
