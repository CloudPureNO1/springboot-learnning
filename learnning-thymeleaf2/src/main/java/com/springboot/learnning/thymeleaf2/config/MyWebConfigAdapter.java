package com.springboot.learnning.thymeleaf2.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by CloudPure on 2017/11/27.
 */
public class MyWebConfigAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //自定义项目内目录
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
        //指向外部目录
        //registry.addResourceHandler("/my/**").addResourceLocations("file:E:/my/");
        super.addResourceHandlers(registry);
    }

    
}
