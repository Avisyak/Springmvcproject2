package com.Broadway.SpringMvcPractiseSession.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Broadway.SpringMvcPractiseSession.Model.Employee;
import com.Broadway.SpringMvcPractiseSession.Service.DepartmentService;
import com.Broadway.SpringMvcPractiseSession.Service.EmployeeService;

@Controller
public class EmployeeController {
 
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/employee")
	public String getEmployee(Model model) {
		model.addAttribute("deptList",deptService.getDepartment());
		
		
		return "AddEmployee";
		
	}
	
	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee employee) {
		empService.addEmployee(employee);
		
		return "redirect:/employee";
		
	}
	
	@GetMapping("/employeelist")
	public String getAll(Model model) {
		model.addAttribute("elist",empService.getAllEmp());
		
		return "ListEmployee";
		
		
	}
	
	@GetMapping("/editemp")
	public String editEmp(@RequestParam int id,Model model) {
		
		model.addAttribute("empmodel",empService.getEmpById(id));
		
		return "EditEmployee";
		
	}
	@PostMapping("/updateemp")
	public String updateemp(@ModelAttribute Employee emp) {
		empService.addEmployee(emp);
		return "redirect:/employeelist";
		
	}
	@GetMapping("/delete")
	public String deleteemp(@RequestParam int id) {
		
		empService.deleteEmployee(id);
		return "redirect:/employeelist";
		
		
	}

	

}
