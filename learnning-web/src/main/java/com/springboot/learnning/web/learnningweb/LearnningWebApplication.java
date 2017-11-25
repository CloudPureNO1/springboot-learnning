package com.springboot.learnning.web.learnningweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @ComponentScan(basePackages = {"com.springboot.learnning.domain.learnningdomain","com.springboot.learnning.web.learnningweb"})
设置烧苗的路径，因为注入的bean 不在启动类的路径下，自动装配后，还是烧苗不到，
 所以要配置 bean的烧苗路径，还要配置自己的扫描路径，需要扫描什么，就可以添加
 比如：learnning-web下的MsgTest 不在启动类的目录下，装配后不能扫描掉，要在启动类中添加对于的路径，同时，为了能够烧苗到启动类目录下的
 也还需要添加，自己的目录。

 如果注入的类  的路径在启动类的路径下，则可以不用配置扫描路劲，比如：learnning-web-vo 模块下的TestVO.java
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.learnning.domain.learnningdomain","com.springboot.learnning.web.learnningweb"})
public class LearnningWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnningWebApplication.class, args);
	}
}
