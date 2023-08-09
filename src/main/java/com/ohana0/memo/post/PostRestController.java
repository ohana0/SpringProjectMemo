package com.ohana0.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ohana0.memo.post.service.PostService;

@RestController
public class PostRestController {
	@Autowired
	private PostService postService;
	
	@PostMapping("/post/create")
	public Map<String,String> createMemo(
			@RequestParam("title") String title
			,@RequestParam("content") String content
			, @RequestParam(value="file", required=false) MultipartFile file
			,HttpSession session
			){
		
		Map<String,String> resultMap = new HashMap<>();
		
		
		int userId = (Integer) session.getAttribute("userId");
		
		int count = postService.addMemo(userId,title, content,file);
		
		if(count == 1) {
			
			resultMap.put("result", "success");
		}
		else {
			resultMap.put("result","fail");
		}
		
		
		
		return resultMap;
		
	}
	@PostMapping("/post/update")
	public Map<String,String> updateMemo(
			@RequestParam("title") String title
			,@RequestParam("content") String content
			,HttpSession session
			){
		

		int id = (int) session.getAttribute("postId") ;
		
		int count = postService.updatePost(id,title,content);
		
		Map<String,String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		}
		else {
			resultMap.put("result", "fail");
		}
		session.removeAttribute("postId");
		return resultMap;
		
		
	}
	@DeleteMapping("/post/delete")
	public Map<String,String> deletePost(HttpSession session){
		
		int id = (int) session.getAttribute("postId");
		
		int count = postService.deletePost(id);
		
		Map<String,String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		}
		else {
			resultMap.put("result", "fail");
		}
		session.removeAttribute("postId");
		return resultMap;
		
	}
	
	
	
	
	
	
}
