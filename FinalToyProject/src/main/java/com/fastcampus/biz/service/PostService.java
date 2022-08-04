package com.fastcampus.biz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Post;
import com.fastcampus.biz.persistence.PostRepository;
import com.fastcampus.web.dto.RequestPost;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	
	public Post getPost(Long postId) {
		return postRepository.findById(postId).get();
	}
	
	public List<Post> getPosts(Long blogId) {
		return postRepository.findByBlogId(blogId);
	}
	
	public List<Post> getPostsByCategoryId(Long categoryId) {
		return postRepository.findByCategoryId(categoryId);
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
	public void updatePost(Long postId, RequestPost requestPost) {
		Post post = postRepository.findById(postId).get();
		post.setCategoryId(requestPost.getCategoryId());
		post.setContent(requestPost.getContent());
		post.setTitle(requestPost.getTitle());
	}
	
	@Transactional
	public void deletePostByPostId(Long postId) {
		postRepository.deleteById(postId);
	}
	
	public void deletePostByBlogId(Long blogId) {
		postRepository.deleteByBlogId(blogId);
	}
}
