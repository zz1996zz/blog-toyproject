package com.fastcampus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastcampus.biz.persistence.BlogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WelcomeController {

	private final BlogRepository blogRepository;

	@GetMapping({ "", "/" })
	public String welcome(Model model) {
		model.addAttribute("blogList", blogRepository.findAll());
		log.info("model={}", model.toString());
		return "welcome";
	}

	@PostMapping("/find")
	public String findBlog(@RequestParam String searchCondition, @RequestParam String searchKeyword, Model model) {
		log.info("searchCondition={}, searchKeyword={}", searchCondition, searchKeyword);
		if (searchKeyword.isBlank()) {
			model.addAttribute("blogList", blogRepository.findAll());
		} else if (searchCondition.equals(searchCondition)) {
			model.addAttribute("blogList", blogRepository.findByTitleContains(searchKeyword));
		} else if (searchCondition.equals(searchCondition)) {
			model.addAttribute("blogList", blogRepository.findByTagContains(searchKeyword));
		}
		log.info("blogList={}", blogRepository.findByTitleContains(searchKeyword));
		log.info("model={}", model.toString());
		return "welcome";
	}
}
