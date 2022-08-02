package com.fastcampus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.biz.service.BlogService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

	private final BlogService blogService;
	
	@GetMapping("/insert")
	public String getBlogInsertForm() {
		return "blog/insertBlog";
	}
	
	@PostMapping("/insert")
	public String insertBlog() {
		return "redirect:";
	}
	
	@GetMapping("/shortcuts")
	public String getBlog() {
		return "blog/blogMain";
	}
	
}
