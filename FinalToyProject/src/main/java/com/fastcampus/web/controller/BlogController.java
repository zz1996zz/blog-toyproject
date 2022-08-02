package com.fastcampus.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastcampus.biz.service.BlogService;
import com.fastcampus.biz.service.PostService;
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
	public String getBlog(@PathVariable Integer id, Model model) {
		model.addAttribute("blog", blogService.getBlog(id));
		model.addAttribute("posts", postService.getPosts(id));
		return "blog/blogMain";
	}
	
	@GetMapping("/manage")
	public String manage() {
		return "blog/getBlog";
	}
}
