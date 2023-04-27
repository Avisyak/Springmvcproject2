package com.Broadway.SpringMvcPractiseSession.Model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Employee_tbl")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	private String gender;
	private String phone;
	private String email;
	private String company;
	private String post;
	private int salary;
	
	@OneToOne
	@JoinColumn(name="department_tbl")
	private Department department;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_tbl")
	private Address address;
	
	@ElementCollection
	@CollectionTable
	private List<String> project;
	
}
