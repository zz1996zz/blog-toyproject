package com.fastcampus.biz.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.biz.domain.BlogUser;

@Repository
public interface BlogUserRepository extends JpaRepository<BlogUser, Integer> {

}