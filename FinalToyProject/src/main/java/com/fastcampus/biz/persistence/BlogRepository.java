package com.fastcampus.biz.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.biz.domain.Blog;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

	List<Blog> findByTitleContains(String title);
	List<Blog> findByTagContains(String tag); 
}
