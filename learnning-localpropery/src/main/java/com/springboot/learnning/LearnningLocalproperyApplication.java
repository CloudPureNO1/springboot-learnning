package com.springboot.learnning;

import com.springboot.learnning.myconfig.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(UserConfig.class)
public class LearnningLocalproperyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnningLocalproperyApplication.class, args);
	}
}
