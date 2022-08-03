package com.fastcampus.biz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Category;
import com.fastcampus.biz.persistence.CategoryRepository;
import com.fastcampus.web.domain.UpdateCategory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepository categoryRepository;
	
	public List<Category> getCategoryList(int blogId) {
		return categoryRepository.findByBlogId(blogId);
	}
	
	public Category getCategory(int categoryId) {
		return categoryRepository.findById(categoryId).get();
	}
	
	public void insertCategory(Category category) {
		categoryRepository.save(category);
	}
	
	@Transactional
	public void updateCategory(int categoryId, UpdateCategory updateCategory) {
		Category category = categoryRepository.findById(categoryId).get();
		category.setCategoryName(updateCategory.getCategoryName());
		category.setDescription(updateCategory.getDescription());
		category.setDisplayType(updateCategory.getDisplayType());
	}
	
	@Transactional
	public void deleteCategoryByCategoryId(int categoryId) {
		categoryRepository.deleteById(categoryId);
	}
	
	public void deleteCategoryByBlogId(int blogId) {
		categoryRepository.deleteByBlogId(blogId);
	}
}
