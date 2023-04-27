package com.Broadway.SpringMvcPractiseSession.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue
	private int Id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	

}
