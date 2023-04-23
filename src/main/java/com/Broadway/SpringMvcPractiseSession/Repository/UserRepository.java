package com.Broadway.SpringMvcPractiseSession.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Broadway.SpringMvcPractiseSession.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	 User findByUsernameAndPassword(String un, String psw);

}
