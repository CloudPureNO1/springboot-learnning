package com.springboot.learnning.mybatis1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.learnning.mybatis1.mapper")
public class LearnningMybatis1Application {

	public static void main(String[] args) {
		SpringApplication.run(LearnningMybatis1Application.class, args);
	}
}
