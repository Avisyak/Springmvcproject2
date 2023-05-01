package com.Broadway.SpringMvcPractiseSession.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Broadway.SpringMvcPractiseSession.Model.User;
import com.Broadway.SpringMvcPractiseSession.Repository.UserRepository;
import com.Broadway.SpringMvcPractiseSession.Service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public void userSignup(User user) {
		userRepo.save(user);
		
	}

	@Override
	public User userLogin(String un, String psw) {
		return userRepo.findByUsernameAndPassword(un, psw);
		
	}

}
