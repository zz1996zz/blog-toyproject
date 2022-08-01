package com.fastcampus.biz.service;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.persistence.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepository categoryRepository;
}
