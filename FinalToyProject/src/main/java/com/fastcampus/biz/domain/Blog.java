package com.fastcampus.biz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "BLOG")
@NoArgsConstructor
@AllArgsConstructor
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
