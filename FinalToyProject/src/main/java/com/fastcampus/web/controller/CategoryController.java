package com.fastcampus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.biz.service.BlogService;
import com.fastcampus.biz.service.CategoryService;
import com.fastcampus.web.dto.RequestCategory;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	private final BlogService blogService;
	
	@GetMapping("/getCategoryList/{blogId}/insert")
	public String getCategoryList(@PathVariable Long blogId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));
		model.addAttribute("categoryList", categoryService.getCategoryList(blogId));
		return "category/getCategoryList";
	}
	
	@GetMapping("/getCategory/{blogId}/update/{categoryId}")
	public String getCategory(@PathVariable Long blogId, @PathVariable Long categoryId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));
		model.addAttribute("category", categoryService.getCategory(categoryId));
		model.addAttribute("categoryList", categoryService.getCategoryList(blogId));
		return "category/getCategoryList";
	}
	
	@PostMapping("/insert/{blogId}")
	public String insertCategory(@ModelAttribute RequestCategory requestCategory) {
		categoryService.insertCategory(requestCategory);
		return "redirect:/categories/getCategoryList/{blogId}/insert";
	}
	
	@PostMapping("/update/{blogId}/{categoryId}")
	public String updateCategory(@PathVariable Long categoryId, @ModelAttribute RequestCategory requestCategory) {
		categoryService.updateCategory(categoryId, requestCategory);
		return "redirect:/categories/getCategoryList/{blogId}/insert";
	}
	
	@GetMapping("/{blogId}/{categoryId}")
	public String deleteCategory(@PathVariable Long categoryId) {
		categoryService.deleteCategoryByCategoryId(categoryId);
		return "redirect:/categories/getCategoryList/{blogId}/insert";
	}
}
