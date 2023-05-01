package com.Broadway.SpringMvcPractiseSession.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Broadway.SpringMvcPractiseSession.Model.Employee;
import com.Broadway.SpringMvcPractiseSession.Service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/emp/api/list")
	public List<Employee> getAllemp() {
		
		return empService.getAllEmp();
	}
	

}
