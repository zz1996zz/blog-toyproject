package com.fastcampus.biz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Category;
import com.fastcampus.biz.persistence.CategoryRepository;
import com.fastcampus.web.dto.RequestCategory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepository categoryRepository;
	
	public List<Category> getCategoryList(Long blogId) {
		return categoryRepository.findByBlogId(blogId);
	}
	
	public Category getCategory(Long categoryId) {
		return categoryRepository.findById(categoryId).get();
	}
	
	public void insertBasicCategory(Long blogId) {
		Category category = new Category(blogId, "미분류", "기본으로 제공되는 카테고리입니다.", "MIXED");
		categoryRepository.save(category);
	}
	
	public void insertCategory(RequestCategory rc) {
		Category category = new Category(rc.getBlogId(), rc.getCategoryName(), rc.getDescription(), rc.getDisplayType());
		categoryRepository.save(category);
	}
	
	@Transactional
	public void updateCategory(Long categoryId, RequestCategory rc) {
		Category category = categoryRepository.findById(categoryId).get();
		category.setCategoryName(rc.getCategoryName());
		category.setDescription(rc.getDescription());
		category.setDisplayType(rc.getDisplayType());
	}
	
	@Transactional
	public void deleteCategoryByCategoryId(Long categoryId) {
		categoryRepository.deleteById(categoryId);
	}
	
	public void deleteCategoryByBlogId(Long blogId) {
		categoryRepository.deleteByBlogId(blogId);
	}
}
