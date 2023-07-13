package com.greenstitchio.service;

import com.greenstitchio.exception.UserException;
import com.greenstitchio.model.User;

public interface LoginService {
	public User LoginByEmail(String email) throws UserException;

}
