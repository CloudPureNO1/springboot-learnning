package com.springboot.learnning.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.learnning.mybatis.mapper")
public class LearnningMybatisXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnningMybatisXmlApplication.class, args);
	}
}
