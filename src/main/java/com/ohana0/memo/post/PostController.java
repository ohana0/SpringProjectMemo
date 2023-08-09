package com.ohana0.memo.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ohana0.memo.post.domain.Post;
import com.ohana0.memo.post.service.PostService;
@RequestMapping("/post")
@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping("/list-view")
	public String list(Model model,HttpSession session) {
		int userId = (Integer)session.getAttribute("userId");
		List<Post> postList = postService.getPostList(userId);
		
		model.addAttribute(postList);
		return "/post/list";
	}
	
	
	@GetMapping("/create-view")
	public String input() {
		return "/post/input";
	}
	
	@GetMapping("/detail-view/{id}")
	public String detail(@PathVariable("id") int id , Model model, HttpSession session) {
		session.setAttribute("postId", id);
		Post post = postService.getPost(id);
		model.addAttribute("memo", post);
		return "/post/detail";
	}
}
