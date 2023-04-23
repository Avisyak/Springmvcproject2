package com.Broadway.SpringMvcPractiseSession.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Broadway.SpringMvcPractiseSession.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
