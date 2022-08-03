package com.fastcampus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.biz.domain.Category;
import com.fastcampus.biz.service.BlogService;
import com.fastcampus.biz.service.CategoryService;
import com.fastcampus.web.domain.UpdateCategory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	private final BlogService blogService;
	
	@GetMapping("/getCategoryList/{blogId}/insert")
	public String getCategoryList(@PathVariable int blogId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));
		model.addAttribute("categoryList", categoryService.getCategoryList(blogId));
		return "category/getCategoryList";
	}
	
	@GetMapping("/getCategory/{blogId}/update/{categoryId}")
	public String getCategory(@PathVariable int blogId, @PathVariable int categoryId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));
		model.addAttribute("category", categoryService.getCategory(categoryId));
		model.addAttribute("categoryList", categoryService.getCategoryList(blogId));
		return "category/getCategoryList";
	}
	
	@PostMapping("/insert/{blogId}")
	public String insertCategory(@ModelAttribute Category category) {
		log.info("category={}", category);
		categoryService.insertCategory(category);
		return "redirect:/category/getCategoryList/{blogId}/insert";
	}
	
	@PostMapping("/update/{blogId}/{categoryId}")
	public String updateCategory(@PathVariable int categoryId, @ModelAttribute UpdateCategory updateCategory) {
		categoryService.updateCategory(categoryId, updateCategory);
		return "redirect:/category/getCategoryList/{blogId}/insert";
	}
	
	@GetMapping("/{blogId}/{categoryId}")
	public String deleteCategory(@PathVariable int categoryId) {
		categoryService.deleteCategoryByCategoryId(categoryId);
		return "redirect:/category/getCategoryList/{blogId}/insert";
	}
}
