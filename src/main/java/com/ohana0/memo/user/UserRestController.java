package com.ohana0.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ohana0.memo.user.domain.User;
import com.ohana0.memo.user.service.UserService;

@RequestMapping("/user")
@RestController// controller+responsebody >> view같은 경로만리턴하는경우
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/join")
	public Map<String,String> join(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,@RequestParam("name") String name
			,@RequestParam("email") String email) {
		
		User user = userService.addUser(loginId,password,name,email);
		
		Map<String,String> resultMap = new HashMap<>();
		if(user != null) {
			resultMap.put("result","success");
		}
		else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	@PostMapping("/login")
	public Map<String,String> login(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password			
			){
		Map<String,String> resultMap  = new HashMap<>();
		
		userService.login(loginId,password);
		
		
		
		
		
		
	}
	

}
