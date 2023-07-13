package com.greenstitchio.repo;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenstitchio.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	public Optional<User> findByEmail(String email);

}
