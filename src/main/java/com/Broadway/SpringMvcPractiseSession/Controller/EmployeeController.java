package com.Broadway.SpringMvcPractiseSession.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Broadway.SpringMvcPractiseSession.Model.Employee;
import com.Broadway.SpringMvcPractiseSession.Service.DepartmentService;
import com.Broadway.SpringMvcPractiseSession.Service.EmployeeService;
import com.Broadway.SpringMvcPractiseSession.utils.EmployeeExcelView;
import com.Broadway.SpringMvcPractiseSession.utils.EmployeePdfView;

@Controller
public class EmployeeController {
 
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/employee")
	public String getEmployee(Model model,HttpSession session) {
		if(session.getAttribute("activeuser") ==null) {
			   return "LoginForm";
		   }
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
	@GetMapping("/excel")
	public ModelAndView exportToExcel() {
		ModelAndView m =  new ModelAndView();
		m.setView(new EmployeeExcelView());

		//read data from DB
		List<Employee> list = empService.getAllEmp();
		//send to Excel Impl class
		m.addObject("list", list);

		return m;
	}
	/***
	 * 9. export data to PDF file
	 */
	@GetMapping("/pdf")
	public ModelAndView exportToPdf() {
		ModelAndView m = new ModelAndView();
		m.setView(new EmployeePdfView());
		
		//read data from DB
		List<Employee> list = empService.getAllEmp();
		//send to Excel Impl class
		m.addObject("list", list);

		return m;
	}

}
