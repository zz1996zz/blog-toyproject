package com.fastcampus.biz.domain;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "POST")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Post {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	
	@Column(name = "BLOGID", nullable = false)
	private Long blogId;

	@Column(name = "CATEGORYID", nullable = false)
	private Long categoryId;
	
	@Lob
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "CREATEDDATE")
	@CreatedDate
	private LocalDate createdDate;
	
	@Column(name = "MODIFIEDDATE")
	@LastModifiedDate
	private LocalDate modifiedDate;
	
	@Column(name = "TITLE")
	private String title;

	public Post(Long blogId, Long categoryId, String content, String title) {
		this.blogId = blogId;
		this.categoryId = categoryId;
		this.content = content;
		this.title = title;
	}
}
