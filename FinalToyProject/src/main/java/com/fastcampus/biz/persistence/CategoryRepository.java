package com.fastcampus.biz.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.biz.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findByBlogId(int blogId);
	void deleteByBlogId(int blogId);
}
