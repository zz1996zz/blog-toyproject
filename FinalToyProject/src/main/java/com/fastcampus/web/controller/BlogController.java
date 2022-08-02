package com.fastcampus.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastcampus.biz.service.BlogService;
import com.fastcampus.web.domain.UserInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public String insertBlog(@RequestParam String title, HttpServletRequest request) {
		if (!title.strip().isBlank()) {
			HttpSession session = request.getSession(false);
			UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
			log.info("title={}, userInfo={}", title.strip(), userInfo.toString());
			blogService.insertBlog(title.strip(), userInfo.getUserId());
		}
		return "redirect:/";
	}
	
	@GetMapping("/shortcuts")
	public String getBlog() {
		return "blog/blogMain";
	}
	
}
