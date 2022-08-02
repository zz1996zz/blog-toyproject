package com.fastcampus.biz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Post;
import com.fastcampus.biz.persistence.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	
	public List<Post> getPosts(int blogId) {
		List<Post> posts = postRepository.findByBlogId(blogId);
		return posts;
	}
}
