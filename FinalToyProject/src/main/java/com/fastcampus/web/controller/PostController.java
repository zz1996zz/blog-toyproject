package com.fastcampus.web.controller;

import org.springframework.stereotype.Controller;

import com.fastcampus.biz.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
}
