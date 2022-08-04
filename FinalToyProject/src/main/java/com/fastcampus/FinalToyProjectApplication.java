package com.fastcampus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FinalToyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalToyProjectApplication.class, args);
	}

}
