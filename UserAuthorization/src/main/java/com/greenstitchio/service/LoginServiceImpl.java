package com.greenstitchio.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;

import com.greenstitchio.exception.UserException;
import com.greenstitchio.model.User;
import com.greenstitchio.repo.UserRepo;

public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserRepo uRepo;
	@Override
	public User LoginByEmail(String email) throws UserException {
		java.util.Optional<User> opt = uRepo.findByEmail(email);
		System.out.println(opt.get());
		if(opt.isPresent()) {
			User user = opt.get();
			List<GrantedAuthority> authorities= new ArrayList<>();
			//return new User(user.getEmail(),user.getPassword(), authorities);		
		} 
		
		else throw new BadCredentialsException("User Details not found with this username: "+email);
		
	}
	}

}
