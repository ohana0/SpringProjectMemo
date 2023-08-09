package com.ohana0.memo.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ohana0.memo.post.domain.Post;

@Repository
public interface PostRepository {
	public int insertMemo(
			@Param("userId") int userId
			, @Param("title")String title
			, @Param("content")String content
			, @Param("imagePath") String imagePath
	);

	public List<Post> selectMemoList(@Param("userId") int userId);

	public Post selectMemo(@Param("id") int id);

	public int updateMemo(@Param("id") int id, @Param("title") String title, @Param("content") String content);

	public int deleteMemo(@Param("id")int id);

}
