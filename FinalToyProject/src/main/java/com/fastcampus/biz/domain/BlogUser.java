package com.fastcampus.biz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BLOG_USER")
public class BlogUser {

	@Id
	private Long userId;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "ROLE", nullable = false)
	private String role;
	
	@Column(name = "USERNAME", nullable = false)
	private String username;
}
