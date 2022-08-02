package com.fastcampus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fastcampus.biz.persistence.BlogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WelcomeController {
	
	private final BlogRepository blogRepository;
	
	@GetMapping({"", "/"})
	public String welcome(Model model) {
		model.addAttribute("blogList", blogRepository.findAll());
		return "welcome";
	}

	@PostMapping("/find")
	public String findBlog(@RequestParam String searchCondition, @RequestParam String searchKeyword, RedirectAttributes redirectAttributes) {
		if (searchKeyword == null) {
			redirectAttributes.addAttribute("blogList", blogRepository.findAll());
		} else if (searchCondition == "TITLE") {
			redirectAttributes.addAttribute("blogList", blogRepository.findBytitle(searchKeyword));
		} else if (searchCondition == "TAG") {
			redirectAttributes.addAttribute("blogList", blogRepository.findBytag(searchKeyword));
		}
		log.info("redirectAttributes={}", redirectAttributes.getAttribute("blogList"));
		return "redirect:/";
	}
}
