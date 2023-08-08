package com.ohana0.memo.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohana0.memo.post.domain.Post;
import com.ohana0.memo.post.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public int addMemo(int userId, String title, String content) {
		// TODO Auto-generated method stub
		int count = postRepository.insertMemo(userId, title,content);
		return count;
	}
	
	public List<Post>getPostList(int userId) {
		
		List<Post> postList = postRepository.selectMemoList(userId);
		
		return postList;
	}

	public Post getPost(int id) {
		Post post = postRepository.selectMemo(id);
		return post;
	}
	
}
