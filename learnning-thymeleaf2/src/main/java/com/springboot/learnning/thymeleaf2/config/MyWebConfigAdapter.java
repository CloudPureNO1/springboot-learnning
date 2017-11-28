package com.springboot.learnning.thymeleaf2.config;

import com.springboot.learnning.thymeleaf2.interceptor.LoginHandlerInterceptor;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by CloudPure on 2017/11/27.
 */
@Configuration
public class MyWebConfigAdapter extends WebMvcConfigurerAdapter {
    private static final Logger logger= Logger.getLogger(MyWebConfigAdapter.class);
    /**
     * 想要配置自己静态资源的映射路径，只需要重写 WebMvcConfigurerAdapter 的addResourceHandlers 方法
     * 配置静态资源
     * @param registry
     */

/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //通过addResourceHandler添加映射路径，然后通过addResourceLocations来指定路径
        //addResourceLocations指的是文件放置的目录，addResoureHandler指的是对外暴露的访问路径
        //自定义项目内目录
        registry.addResourceHandler("/my*//**//**").addResourceLocations("classpath:/my/");
        //指向外部目录
        //registry.addResourceHandler("/my*//**//**").addResourceLocations("file:E:/my/");
        super.addResourceHandlers(registry);
    }*/

    /**
     * 1、访问视图界面，先要创建一个Controller,然后写方法跳转到界面
     * 2、也可以重写WebMvcConfigurerAdapter的addViewControllers 方法来实现跳转，
     * 并且不会覆盖，WebMvcconfigurerAdapter中的addViewControllers 方法，
     * 这意味着我们自己的配置和Spring Boot的自动配置同时有效：
     * 所以，有些特定的跳转直接在此处配置更好（比如登陆跳转）
     * <p>This implementation is empty.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置：跳转的url为 toLogin时，默认跳转到login.html界面

        registry.addViewController("/toLogin").setViewName("login");

        logger.info("**************配置：跳转的url为 toLogin时，默认跳转到login.html界面****************");
        super.addViewControllers(registry);
    }


    /**
     * 配置已经写好的LoginHandlerIntercepto拦截器，
     * 重写 WebMvcConfigurerAdapter 的addInterceptors方法
     * <p>This implementation is empty.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns  添加拦截路径
        //excludePathPatterns  排除拦截路径
        //addPathPatterns("/**")对所有请求都拦截，但是排除了/toLogin和/login请求的拦截。
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
        logger.info("*******************/**对所有请求都拦截，但是排除了/toLogin和/login请求的拦截。*******************");
        super.addInterceptors(registry);
    }


}
