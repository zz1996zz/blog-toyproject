package com.fastcampus.biz.service;

import org.springframework.stereotype.Service;

import com.fastcampus.biz.persistence.BlogUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogUserService {

	private final BlogUserRepository blogUserRepository;
}
