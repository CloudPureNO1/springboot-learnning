package com.springboot.learnning.junit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.learnning.junit.mapper")
public class LearnningJunitWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnningJunitWebApplication.class, args);
	}
}
