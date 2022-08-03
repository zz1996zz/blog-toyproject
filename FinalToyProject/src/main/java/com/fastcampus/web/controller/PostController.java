package com.fastcampus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.biz.service.BlogService;
import com.fastcampus.biz.service.CategoryService;
import com.fastcampus.biz.service.PostService;
import com.fastcampus.web.domain.RequestPost;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
	private final BlogService blogService;
	private final CategoryService categoryService;
	
	@GetMapping("/insert/{blogId}")
	public String getInsertPost(@PathVariable int blogId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));
		model.addAttribute("categoryList", categoryService.getCategoryList(blogId));
		return "post/insertPost";
	}
	
	@PostMapping("/insert/{blogId}")
	public String insertPost(@ModelAttribute RequestPost requestPost) {
		log.info("requestPost={}", requestPost);
		postService.insertPost(requestPost);
		return "redirect:/blog/shortcuts/{blogId}";
	}
}
