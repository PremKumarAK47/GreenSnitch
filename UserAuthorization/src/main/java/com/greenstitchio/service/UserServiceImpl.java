package com.greenstitchio.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.greenstitchio.exception.UserException;
import com.greenstitchio.model.User;
import com.greenstitchio.repo.UserRepo;

public class UserServiceImpl implements UserService {
@Autowired
UserRepo uRepo;
	@Override
	public String UserRegistration(User user) {
		if(user == null) throw new UserException("Invalid User Details.");
		uRepo.save(user);
	    return "Registered Successfully...!!";

	}

}
