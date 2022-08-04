package com.fastcampus.biz.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.persistence.BlogRepository;
import com.fastcampus.web.dto.RequestBlog;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {

	private final BlogRepository blogRepository;
	private final CategoryService categoryService;
	private final PostService postService;
	
	public void insertBlog(String title, Long userId) {
		Blog blog = new Blog(userId, "운영", "No tag", title);
		blogRepository.save(blog);
	}
	
	public Blog getBlog(Long blogId) {
		return blogRepository.findById(blogId).get();
	}
	
	@Transactional
	public void updateBlog(Long blogId, RequestBlog updateBlog) {
		Blog blog = blogRepository.findById(blogId).get();
		blog.setTitle(updateBlog.getTitle());
		blog.setTag(updateBlog.getTag());
	}
	
	@Transactional
	public void changeBlogStatus(Long blogId) {
		Blog blog = blogRepository.findById(blogId).get();
		if (blog.getStatus().equals("운영")) {
			blog.setStatus("삭제요청");			
		} else {
			blog.setStatus("운영");
		}
	}
	
	@Transactional
	public void deleteBlog(Long blogId) {
		blogRepository.deleteById(blogId);
		categoryService.deleteCategoryByBlogId(blogId);
		postService.deletePostByBlogId(blogId);
	}
}
