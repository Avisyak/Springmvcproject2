package com.Broadway.SpringMvcPractiseSession.Service;

import java.util.List;

import com.Broadway.SpringMvcPractiseSession.Model.Department;

public interface DepartmentService {
	void addDepartment(Department department);
	List<Department> getDepartment();
	Department getDepartmentByID(int id);
	

}
