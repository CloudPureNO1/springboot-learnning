package com.springboot.learnning.myconfig;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by CloudPure on 2017/12/28.
 * 此处成员变量，也需要通过@Value注解获取值，否则会为空
 */

@Component//使用@Configuration也可以
@ConfigurationProperties(prefix = "user")//前缀
@PropertySource(value = "classpath:myconfig/user.properties")//配置文件路径
public class UserConfig {
    @Value("${com.username}")
    private String username;
    @Value("${com.userpasswd}")
    private String userpasswd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpasswd() {
        return userpasswd;
    }

    public void setUserpasswd(String userpasswd) {
        this.userpasswd = userpasswd;
    }
}
