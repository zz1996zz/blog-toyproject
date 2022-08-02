package com.fastcampus.biz.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.biz.domain.Blog;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findBytitle(String title);
	List<Blog> findBytag(String tag); 
}
