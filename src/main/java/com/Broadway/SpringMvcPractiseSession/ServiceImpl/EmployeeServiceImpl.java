package com.Broadway.SpringMvcPractiseSession.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Broadway.SpringMvcPractiseSession.Model.Employee;
import com.Broadway.SpringMvcPractiseSession.Repository.EmployeeRepository;
import com.Broadway.SpringMvcPractiseSession.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired 
	private EmployeeRepository empRepo;
	
	
	@Override
	public void addEmployee(Employee employee) {
		empRepo.save(employee);
		
	}

	@Override
	public void deleteEmployee(int id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
	      empRepo.save(employee);
		
	}

	@Override
	public Employee getEmpById(int id) {
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmp() {
		
		
		return empRepo.findAll();
	}
	
	

}
