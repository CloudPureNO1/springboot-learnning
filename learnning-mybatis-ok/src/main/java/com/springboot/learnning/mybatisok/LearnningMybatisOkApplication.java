package com.springboot.learnning.mybatisok;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.learnning.mybatisok.mapper")
public class LearnningMybatisOkApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnningMybatisOkApplication.class, args);
	}
}
