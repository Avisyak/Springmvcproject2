package com.Broadway.SpringMvcPractiseSession.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Broadway.SpringMvcPractiseSession.Model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
