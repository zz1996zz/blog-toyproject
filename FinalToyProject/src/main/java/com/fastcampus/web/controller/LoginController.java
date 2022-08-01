package com.fastcampus.web.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastcampus.biz.domain.BlogUser;
import com.fastcampus.biz.persistence.BlogUserRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

	private final BlogUserRepository repository;
	
	@GetMapping
	public String login() {
		return "system/login";
	}
	
	@PostMapping
	public String loginUser(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		Optional<BlogUser> findUser = repository.findByUsername(username);
		
		if (findUser.isPresent()) {
			BlogUser user = findUser.get();
			if (user.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user.getUserId());
			}
		}
		return "redirect:/";
	}
}
