package com.Broadway.SpringMvcPractiseSession.Service;

import java.util.List;

import com.Broadway.SpringMvcPractiseSession.Model.Employee;

public interface EmployeeService {
	void addEmployee(Employee employee);
	void deleteEmployee(int id);
	void updateEmployee(Employee employee);
	Employee getEmpById(int id);
	List<Employee> getAllEmp();
	
	

}
