package com.fastcampus.biz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Category {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	@Column(nullable = false)
	private int blogId;
	
	private String categoryName;
	
	private String description;
	
	private String displayType;
}
