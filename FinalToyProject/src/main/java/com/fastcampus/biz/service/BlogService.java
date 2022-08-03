package com.fastcampus.biz.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.domain.Category;
import com.fastcampus.biz.persistence.BlogRepository;
import com.fastcampus.biz.persistence.CategoryRepository;
import com.fastcampus.web.domain.UpdateBlog;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BlogService {

	private final BlogRepository blogRepository;
	private final CategoryRepository categoryRepository;
	private final CategoryService categoryService;
	private final PostService postService;
	
	@Transactional
	public void insertBlog(String title, int userId) {
		Blog blog = new Blog();
		blog.setBlogId(userId);
		blog.setStatus("운영");
		blog.setTag("No tag");
		blog.setTitle(title);
		
		Category category = new Category();
		category.setBlogId(userId);
		category.setCategoryName("미분류");
		category.setDescription("기본으로 제공되는 카테고리입니다.");
		category.setDisplayType("MIXED");
		
		log.info("blog={}", blog.toString());
		log.info("category={}", category.toString());
		
		categoryRepository.save(category);
		blogRepository.save(blog);
	}
	
	public Blog getBlog(int blogId) {
		return blogRepository.findById(blogId).get();
	}
	
	@Transactional
	public void updateBlog(int blogId, UpdateBlog updateBlog) {
		Blog blog = blogRepository.findById(blogId).get();
		blog.setTitle(updateBlog.getTitle());
		blog.setTag(updateBlog.getTag());
	}
	
	@Transactional
	public void changeBlogStatus(int blogId) {
		Blog blog = blogRepository.findById(blogId).get();
		if (blog.getStatus().equals("운영")) {
			blog.setStatus("삭제요청");			
		} else {
			blog.setStatus("운영");
		}
	}
	
	@Transactional
	public void deleteBlog(int blogId) {
		blogRepository.deleteById(blogId);
		categoryService.deleteCategoryByBlogId(blogId);
		postService.deletePostByBlogId(blogId);
	}
}
