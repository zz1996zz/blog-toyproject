package com.fastcampus.web.dto;

import lombok.Data;

@Data
public class RequestPost {

	private Long blogId;

	private Long categoryId;
	
	private String content;
	
	private String title;
}
