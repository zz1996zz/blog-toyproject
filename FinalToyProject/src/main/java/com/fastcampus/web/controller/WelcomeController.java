package com.fastcampus.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.persistence.BlogRepository;
import com.fastcampus.web.dto.ResponseUserInfo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping({ "", "/" })
@RequiredArgsConstructor
public class WelcomeController {

	private final BlogRepository blogRepository;

	@GetMapping
	public String welcome(Model model, HttpServletRequest request) {
		hasBlog(request, model);
		model.addAttribute("blogList", blogRepository.findAll());
		return "welcome";
	}

	@PostMapping
	public String findBlog(@RequestParam String searchCondition, @RequestParam String searchKeyword, Model model, HttpServletRequest request) {
		hasBlog(request, model);
		if (searchKeyword.isBlank()) {
			model.addAttribute("blogList", blogRepository.findAll());
		} else if (searchCondition.equals(searchCondition)) {
			model.addAttribute("blogList", blogRepository.findByTitleContains(searchKeyword));
		} else if (searchCondition.equals(searchCondition)) {
			model.addAttribute("blogList", blogRepository.findByTagContains(searchKeyword));
		}
		return "welcome";
	}
	
	private void hasBlog(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			ResponseUserInfo userInfo = (ResponseUserInfo) session.getAttribute("loginUser");
			if (userInfo != null) {
				Blog blog = blogRepository.findById(userInfo.getUserId()).orElse(null);
				model.addAttribute("blog", blog);								
			}
		} else {
			model.addAttribute("blog", null);
		}
	}
}
