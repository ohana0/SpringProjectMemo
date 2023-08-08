package com.ohana0.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ohana0.memo.post.service.PostService;

@RestController
public class PostRestController {
	@Autowired
	private PostService postService;
	
	@PostMapping("/post/create")
	public Map<String,String> createMemo(
			@RequestParam("title") String title
			,@RequestParam("content") String content
			,HttpSession session
			){
		
		Map<String,String> resultMap = new HashMap<>();
		
		
		int userId = (Integer) session.getAttribute("userId");
		
		int count = postService.addMemo(userId,title, content);
		
		if(count == 1) {
			
			resultMap.put("result", "success");
		}
		else {
			resultMap.put("result","fail");
		}
		
		
		
		return resultMap;
		
	}
	
	public Map<String,String> updateMemo(
			@RequestParam("title") String title
			,@RequestParam("content") String content
			,HttpServletRequest request
			){
		int id = (Integer) request.getAttribute("id");
		postService.updatePost(id,title,content)
		
		
	}
	
	
	
	
	
	
}
