package com.springboot.learnning.web.learnningweb.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class EncodingConfig extends WebMvcConfigurerAdapter{
private static final Logger logger=Logger.getLogger(EncodingConfig.class);

    /**
     * 解决Controller 乱码
     * @return
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter(){
        StringHttpMessageConverter converter= new StringHttpMessageConverter(Charset.forName("UTF-8"));
        logger.info("****************************Encoding=UTF-8************************************");
        return converter;
    }


    @Override
     public void configureMessageConverters(
             List<HttpMessageConverter<?>> converters) {
                 super.configureMessageConverters(converters);
                converters.add(responseBodyConverter());
           }

             @Override
     public void configureContentNegotiation(
             ContentNegotiationConfigurer configurer) {
               configurer.favorPathExtension(false);
           }
}
