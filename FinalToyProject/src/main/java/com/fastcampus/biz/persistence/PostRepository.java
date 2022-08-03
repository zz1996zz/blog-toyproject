package com.fastcampus.biz.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.biz.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByBlogId(int blogId);
	void deleteByBlogId(int blogId);
}
