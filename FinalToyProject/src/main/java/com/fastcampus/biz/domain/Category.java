package com.fastcampus.biz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
	@Column(name = "BLOGID", nullable = false)
	private Long blogId;
	
	@Column(name = "CATEGORYNAME")
	private String categoryName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "DISPLAYTYPE")
	private String displayType; //TITLE or MIXED
}
