package com.fastcampus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastcampus.biz.persistence.BlogRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping({ "", "/" })
@RequiredArgsConstructor
public class WelcomeController {

	private final BlogRepository blogRepository;

	@GetMapping
	public String welcome(Model model) {
		model.addAttribute("blogList", blogRepository.findAll());
		return "welcome";
	}

	@PostMapping
	public String findBlog(@RequestParam String searchCondition, @RequestParam String searchKeyword, Model model) {
		if (searchKeyword.isBlank()) {
			model.addAttribute("blogList", blogRepository.findAll());
		} else if (searchCondition.equals(searchCondition)) {
			model.addAttribute("blogList", blogRepository.findByTitleContains(searchKeyword));
		} else if (searchCondition.equals(searchCondition)) {
			model.addAttribute("blogList", blogRepository.findByTagContains(searchKeyword));
		}
		return "welcome";
	}
}
