package com.Broadway.SpringMvcPractiseSession.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Broadway.SpringMvcPractiseSession.Model.Department;
import com.Broadway.SpringMvcPractiseSession.Repository.DepartmentRepository;
import com.Broadway.SpringMvcPractiseSession.Service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    
	@Autowired
	private DepartmentRepository depRepo;
	
	
	
	@Override
	public void addDepartment(Department department) {
		depRepo.save(department);
		
	}



	@Override
	public List<Department> getDepartment() {
		
		return depRepo.findAll();
	}



	@Override
	public Department getDepartmentByID(int id) {
		
		return depRepo.findById(id).get();
	}



	
}
