package com.fastcampus.web.controller;

import org.springframework.stereotype.Controller;

import com.fastcampus.biz.service.BlogService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BlogController {

	private final BlogService blogService;
}
