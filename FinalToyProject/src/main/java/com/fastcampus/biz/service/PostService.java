package com.fastcampus.biz.service;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.persistence.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
}
