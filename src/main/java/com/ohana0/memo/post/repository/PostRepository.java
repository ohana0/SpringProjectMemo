package com.ohana0.memo.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ohana0.memo.post.domain.Post;

@Repository
public interface PostRepository {
	public int insertMemo(@Param("userId") int userId, @Param("title")String title, @Param("content")String content);

	public List<Post> selectMemoList(@Param("userId") int userId);

	public Post selectMemo(@Param("id") int id);

}
