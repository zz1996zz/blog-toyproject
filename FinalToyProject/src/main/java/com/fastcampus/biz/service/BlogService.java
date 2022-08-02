package com.fastcampus.biz.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.domain.Category;
import com.fastcampus.biz.persistence.BlogRepository;
import com.fastcampus.biz.persistence.CategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BlogService {

	private final BlogRepository blogRepository;
	private final CategoryRepository categoryRepository;
	
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
}
