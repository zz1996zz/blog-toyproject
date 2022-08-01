package com.fastcampus.web.controller;

import org.springframework.stereotype.Controller;

import com.fastcampus.biz.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
}
