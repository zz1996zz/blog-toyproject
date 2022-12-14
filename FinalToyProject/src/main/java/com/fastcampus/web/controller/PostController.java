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
import com.fastcampus.web.dto.RequestPost;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
	private final BlogService blogService;
	private final CategoryService categoryService;
	
	@GetMapping("/insert/{blogId}")
	public String getInsertPost(@PathVariable Long blogId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));
		model.addAttribute("categoryList", categoryService.getCategoryList(blogId));
		return "post/insertPost";
	}
	
	@PostMapping("/insert/{blogId}")
	public String insertPost(@ModelAttribute RequestPost requestPost) {
		postService.insertPost(requestPost);
		return "redirect:/blogs/blog/{blogId}";
	}
	
	@GetMapping("/update/{blogId}/{postId}")
	public String getUpdatePost(@PathVariable Long blogId, @PathVariable Long postId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));
		model.addAttribute("post", postService.getPost(postId));
		model.addAttribute("categoryList", categoryService.getCategoryList(blogId));
		return "post/getPost";
	}
	
	@PostMapping("/update/{blogId}/{postId}")
	public String updatePost(@ModelAttribute RequestPost requestPost, @PathVariable Long postId) {
		postService.updatePost(postId, requestPost);
		return "redirect:/blogs/blog/{blogId}";
	}
	
	@GetMapping("/{blogId}/{postId}")
	public String deletePost(@PathVariable Long postId) {
		postService.deletePostByPostId(postId);
		return "redirect:/blogs/blog/{blogId}";
	}
}
