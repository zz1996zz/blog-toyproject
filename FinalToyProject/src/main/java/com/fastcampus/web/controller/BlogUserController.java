package com.fastcampus.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastcampus.biz.service.BlogUserService;
import com.fastcampus.web.dto.ResponseUserInfo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class BlogUserController {

	private final BlogUserService blogUserService;
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "system/login";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		ResponseUserInfo userInfo = blogUserService.getBlogUser(username, password);
		if (userInfo.getUserId() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", userInfo);
		}
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}
