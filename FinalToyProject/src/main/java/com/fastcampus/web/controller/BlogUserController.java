package com.fastcampus.web.controller;

import org.springframework.stereotype.Controller;

import com.fastcampus.biz.service.BlogUserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BlogUserController {

	private final BlogUserService blogUserService;
}
