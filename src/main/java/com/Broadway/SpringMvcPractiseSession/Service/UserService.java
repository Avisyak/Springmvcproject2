package com.Broadway.SpringMvcPractiseSession.Service;

import com.Broadway.SpringMvcPractiseSession.Model.User;

public interface UserService {
	void userSignup(User user);
	User userLogin(String un, String psw);

}
