package com.fastcampus.biz.service;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.persistence.BlogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {

	private final BlogRepository blogRepository;
}
