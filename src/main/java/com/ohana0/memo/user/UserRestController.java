package com.ohana0.memo.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		
		User user = userService.getUser(loginId,password);
		Map<String,String> resultMap = new HashMap<>();
		if(user == null) {
			user = userService.addUser(loginId,password,name,email);
			
			if(user != null) {
				resultMap.put("result","success");
			}
			else {
				resultMap.put("result", "fail");
			}
			
		}
		else {
			resultMap.put("result","fail");
		}
		return resultMap;
	}
	@PostMapping("/login")
	public Map<String,String> login(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,HttpServletRequest request
			){
		
		Map<String,String> resultMap  = new HashMap<>();
		
		User user = userService.getUser(loginId,password);
		
		if(user == null) {
			
			resultMap.put("result", "fail");
		}
		else {
			resultMap.put("result", "success");
			HttpSession session = request.getSession();
			//session에 userId라는 키로 값이 저장되어있으면 로그인된 상태
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			
		}
		

		
		
		
		return resultMap;
		
		
	}
	

}
