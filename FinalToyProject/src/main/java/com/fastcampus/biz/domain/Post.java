package com.fastcampus.biz.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "POST")
public class Post {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	
	@Column(name = "BLOGID", nullable = false)
	private Long blogId;

	@Column(name = "CATEGORYID", nullable = false)
	private Long categoryId;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "CREATEDDATE")
	@CreationTimestamp
	private Timestamp createdDate;
	
	@Column(name = "MODIFIEDDATE")
	@UpdateTimestamp
	private Timestamp modifiedDate;
	
	@Column(name = "TITLE")
	private String title;
}
