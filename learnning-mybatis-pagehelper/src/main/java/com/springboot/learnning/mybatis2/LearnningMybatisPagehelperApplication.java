package com.springboot.learnning.mybatis2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.learnning.mybatis2.mapper")
public class LearnningMybatisPagehelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnningMybatisPagehelperApplication.class, args);
	}
}
