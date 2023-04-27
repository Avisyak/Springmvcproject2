package com.Broadway.SpringMvcPractiseSession.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="department_tbl")
public class Department {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String dept_name;
	private String dept_hod;
	private String dept_phone;
	public String getDept_phone() {
		return dept_phone;
	}
	public void setDept_phone(String dept_phone) {
		this.dept_phone = dept_phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_hod() {
		return dept_hod;
	}
	public void setDept_hod(String dept_hod) {
		this.dept_hod = dept_hod;
	}
	

}
