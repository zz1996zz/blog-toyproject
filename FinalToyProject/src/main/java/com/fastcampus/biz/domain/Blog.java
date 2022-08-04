package com.fastcampus.biz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BLOG")
public class Blog {

	@Id
	private Long blogId;
	
	@Column(name = "STATUS")
	private String status; //운영 or 삭제요청
	
	@Column(name = "TAG")
	private String tag;
	
	@Column(name = "TITLE")
	private String title;
}
