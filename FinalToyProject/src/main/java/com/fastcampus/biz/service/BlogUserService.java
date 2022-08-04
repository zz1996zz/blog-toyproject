package com.fastcampus.biz.service;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.BlogUser;
import com.fastcampus.biz.persistence.BlogUserRepository;
import com.fastcampus.web.dto.ResponseUserInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogUserService {

	private final BlogUserRepository blogUserRepository;
	
	public ResponseUserInfo getBlogUser(String username, String password) {
		ResponseUserInfo userInfo;
		BlogUser blogUser = blogUserRepository.findByUsername(username)
				.orElse(null);
		if (blogUser != null && blogUser.getPassword().equals(password)) {
			userInfo = new ResponseUserInfo(blogUser.getUserId(), blogUser.getRole());
		} else {
			userInfo = new ResponseUserInfo();
		}
		return userInfo;
	}
}
