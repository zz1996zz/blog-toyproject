package com.fastcampus.biz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Post;
import com.fastcampus.biz.persistence.PostRepository;
import com.fastcampus.web.domain.RequestPost;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	
	public List<Post> getPosts(int blogId) {
		List<Post> posts = postRepository.findByBlogId(blogId);
		return posts;
	}
	
	public void insertPost(RequestPost requestPost) {
		Post post = new Post();
		post.setBlogId(requestPost.getBlogId());
		post.setCategoryId(requestPost.getCategoryId());
		post.setContent(requestPost.getContent());
		post.setTitle(requestPost.getTitle());
		
		postRepository.save(post);
	}
}
