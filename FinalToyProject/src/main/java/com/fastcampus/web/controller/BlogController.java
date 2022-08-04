package com.fastcampus.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastcampus.biz.service.BlogService;
import com.fastcampus.biz.service.CategoryService;
import com.fastcampus.biz.service.PostService;
import com.fastcampus.web.dto.UpdateBlog;
import com.fastcampus.web.dto.ResponseUserInfo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

	private final BlogService blogService;
	private final PostService postService;
	private final CategoryService categoryService;
	
	@GetMapping("/insert")
	public String getBlogInsertForm() {
		return "blog/insertBlog";
	}
	
	@PostMapping("/insert")
	public String insertBlog(@RequestParam String title, HttpServletRequest request) {
		if (!title.strip().isBlank()) {
			HttpSession session = request.getSession(false);
			ResponseUserInfo userInfo = (ResponseUserInfo) session.getAttribute("loginUser");
			blogService.insertBlog(title.strip(), userInfo.getUserId());
		}
		return "redirect:/";
	}
	
	@GetMapping("/shortcuts/{id}")
	public String getBlog(@PathVariable Long id, Model model) {
		model.addAttribute("blog", blogService.getBlog(id));
		model.addAttribute("posts", postService.getPosts(id));
		model.addAttribute("categoryList", categoryService.getCategoryList(id));
		return "blog/blogMain";
	}
	
	@GetMapping("/shortcuts/{id}/{categoryId}")
	public String getBlogByCategory(@PathVariable Long id, @PathVariable Long categoryId, Model model) {
		model.addAttribute("blog", blogService.getBlog(id));
		model.addAttribute("posts", postService.getPostsByCategoryId(categoryId));
		model.addAttribute("categoryList", categoryService.getCategoryList(id));
		return "blog/blogMain";
	}
	
	@GetMapping("/manage/{blogId}")
	public String manage(@PathVariable Long blogId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));
		return "blog/getBlog";
	}
	
	@PostMapping("/update/{id}")
	public String updateBlog(@PathVariable Long id, @ModelAttribute UpdateBlog updateBlog) {
		blogService.updateBlog(id, updateBlog);
		return "redirect:/blog/shortcuts/{id}";
	}
	
	@GetMapping("/status/{blogId}")
	public String isChangeBlogStatus(@PathVariable Long blogId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));
		return "blog/deleteRequest";
	}
	
	@PostMapping("/status/{blogId}")
	public String changeBlogStatus(@PathVariable Long blogId) {
		blogService.changeBlogStatus(blogId);
		return "redirect:/blog/shortcuts/{blogId}";
	}
	
	@GetMapping("/{blogId}")
	public String deleteBlog(@PathVariable Long blogId) {
		blogService.deleteBlog(blogId);
		return "redirect:/";
	}
	
}
