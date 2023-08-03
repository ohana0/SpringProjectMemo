package com.ohana0.memo.user.service;

import java.util.List;

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
	
	public User getUser(String loginId,String password) {
		//String encryptPassword = EncryptUtils.md5(password);
		List<User> userList = userRepository.findByLoginIdAndPassword(loginId,password);
		User user;
		if(userList.size() != 0) {
			user = userList.get(0);
			
		}
		else {
			user = null;
		}
		return user;
	}
	
	
	

	
	
	
	

}
