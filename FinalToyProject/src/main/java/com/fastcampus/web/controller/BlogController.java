package com.fastcampus.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastcampus.biz.service.BlogService;
import com.fastcampus.biz.service.PostService;
import com.fastcampus.web.domain.UpdateBlog;
import com.fastcampus.web.domain.UserInfo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

	private final BlogService blogService;
	private final PostService postService;
	
	@GetMapping("/insert")
	public String getBlogInsertForm() {
		return "blog/insertBlog";
	}
	
	@PostMapping("/insert")
	public String insertBlog(@RequestParam String title, HttpServletRequest request) {
		if (!title.strip().isBlank()) {
			HttpSession session = request.getSession(false);
			UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
			blogService.insertBlog(title.strip(), userInfo.getUserId());
		}
		return "redirect:/";
	}
	
	@GetMapping("/shortcuts/{id}")
	public String getBlog(@PathVariable int id, Model model) {
		model.addAttribute("blog", blogService.getBlog(id));
		model.addAttribute("posts", postService.getPosts(id));
		return "blog/blogMain";
	}
	
	@GetMapping("/manage/{blogId}")
	public String manage(@PathVariable int blogId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));
		return "blog/getBlog";
	}
	
	@PostMapping("/update/{id}")
	public String updateBlog(@PathVariable int id, @ModelAttribute UpdateBlog updateBlog) {
		blogService.updateBlog(id, updateBlog);
		return "redirect:/blog/shortcuts/{id}";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBlog(@PathVariable int id) {
		blogService.deleteBlog(id);
		return "redirect:/blog/shortcuts/{id}";
	}
}
