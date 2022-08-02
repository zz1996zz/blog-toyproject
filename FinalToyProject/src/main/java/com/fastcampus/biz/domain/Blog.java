package com.fastcampus.biz.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Blog {

	@Id
	private int blogId;
	
	private String status; //운영 or 삭제요청
	
	private String tag;
	
	private String title;
}
