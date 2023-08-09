package com.ohana0.memo.post.domain;

import java.util.Date;

import javax.persistence.Column;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Post {

	private int id;
	private int userId;
	private String title;
	private String content;
	private String imagePath;
	
	@UpdateTimestamp
	@Column(name="createdAt",updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updatedAt",updatable=true)
	private Date updatedAt;
	
	
}
