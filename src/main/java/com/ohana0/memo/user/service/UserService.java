package com.ohana0.memo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohana0.memo.user.domain.User;
import com.ohana0.memo.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User addUser(
			String loginId
			, String password
			, String name
			, String email)
	{
		
		User user = User.builder()
			.loginId(loginId)
			.password(password)
			.name(name)
			.email(email)
			.build();
		
		user = userRepository.save(user);
		
		return user; 
	}

	public  login(String loginId, String password) {

		
	}
	
	
	
	

}
