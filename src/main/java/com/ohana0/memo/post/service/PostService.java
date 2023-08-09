package com.ohana0.memo.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ohana0.memo.common.FileManager;
import com.ohana0.memo.post.domain.Post;
import com.ohana0.memo.post.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public int addMemo(int userId, String title, String content, MultipartFile file) {
		// TODO Auto-generated method stub
		String imagePath = FileManager.saveFile(userId, file);

		int count = postRepository.insertMemo(userId, title,content,imagePath);
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

	public int updatePost(int id, String title, String content) {
		int count = postRepository.updateMemo(id,title,content);
		return count;
	}

	public int deletePost(int id) {
		int count = postRepository.deleteMemo(id);
		return count;
	}


	
}
