package com.fastcampus.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCategory {

	private Long blogId;
	private String categoryName;
	private String description;
	private String displayType;
}
