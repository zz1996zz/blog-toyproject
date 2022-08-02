package com.fastcampus.web.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.domain.BlogUser;
import com.fastcampus.biz.persistence.BlogRepository;
import com.fastcampus.biz.persistence.BlogUserRepository;
import com.fastcampus.web.domain.UserInfo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

	private final BlogUserRepository blogUserRepository;
	private final BlogRepository blogRepository;
	
	@GetMapping
	public String login() {
		return "system/login";
	}
	
	@PostMapping
	public String loginUser(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		Optional<BlogUser> findUser = blogUserRepository.findByUsername(username);
		
		if (findUser.isPresent()) {
			BlogUser user = findUser.get();
			
			if (user.getPassword().equals(password)) {
				Optional<Blog> findBlog = blogRepository.findById(user.getUserId());
				UserInfo userInfo;
				HttpSession session = request.getSession();
				
				if (findBlog.isPresent()) {
					userInfo = new UserInfo(user.getUserId(), user.getRole(), true);
				} else {
					userInfo = new UserInfo(user.getUserId(), user.getRole(), false);
				}
				session.setAttribute("loginUser", userInfo);
			}
		}
		return "redirect:/";
	}
}
