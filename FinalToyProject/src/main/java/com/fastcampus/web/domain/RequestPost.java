package com.fastcampus.web.domain;

import lombok.Data;

@Data
public class RequestPost {

	private int blogId;

	private int categoryId;
	
	private String content;
	
	private String title;
}
