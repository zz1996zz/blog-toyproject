package com.fastcampus.biz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Post;
import com.fastcampus.biz.persistence.PostRepository;
import com.fastcampus.web.domain.RequestPost;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	
	public Post getPost(int postId) {
		return postRepository.findById(postId).get();
	}
	
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
	
	@Transactional
	public void updatePost(int postId, RequestPost requestPost) {
		Post post = postRepository.findById(postId).get();
		post.setCategoryId(requestPost.getCategoryId());
		post.setContent(requestPost.getContent());
		post.setTitle(requestPost.getTitle());
	}
}
