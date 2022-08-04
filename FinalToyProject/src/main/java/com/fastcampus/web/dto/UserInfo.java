package com.fastcampus.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfo {

	private Long userId;
	private String role;
}
