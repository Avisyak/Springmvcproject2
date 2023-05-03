package com.Broadway.SpringMvcPractiseSession.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	@PostMapping("/emp/api/add")
	public String add(@RequestBody Employee employee) {
		
		
		empService.addEmployee(employee);
		return "addsuccess";
	}
	@PutMapping("/emp/api/update")
	public String update(@RequestBody Employee employee) {
		
		empService.updateEmployee(employee);
		return "update Success";
	}
	@DeleteMapping("/emp/api/delete/{id}")
	public String delete(@PathVariable int id) {
		empService.deleteEmployee(id);
		return "delete success";
	}
	@GetMapping("/emp/api/{id}")
	public Employee getOneEmp(@PathVariable int id) {
		return empService.getEmpById(id);
	}
	@GetMapping("/emp/api/j2o")
	public String jsonToObjectMapping() {
		RestTemplate temp=new RestTemplate();
		Employee emp=temp.getForObject("http://localhost:9000/emp/api/4", Employee.class);
		return "email="+emp.getEmail();
	}
	@GetMapping("/emp/api/jarray")
	public String jsonArrayToObjectArray() {
		RestTemplate temp = new RestTemplate();
		Employee[] emps= temp.getForObject("http://localhost:9000/emp/api/list", Employee[].class);
		return "email = "+emps[3].getEmail();
	}
	

}
