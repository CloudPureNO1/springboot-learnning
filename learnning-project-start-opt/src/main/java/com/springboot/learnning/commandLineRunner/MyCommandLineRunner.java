package com.springboot.learnning.commandLineRunner;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



/**
 * Created by CloudPure on 2017/12/28.
 * 项目启动时，有时需要加载一些数据，或做某些操作，
 * springboot 可以实现ComandLineRunner 接口
 * 项目启动时，会自动加载，所有实现CommandLineRunner接口类中的run方法，
 * 可以用@Order注解，或者实现Order接口，来决定执行顺序，
 * value值小的，优先执行
 */
@Component
@Order(value=2)
public class MyCommandLineRunner implements CommandLineRunner{
private static final Logger logger= Logger.getLogger(MyCommandLineRunner.class);
    @Override
    public void run(String... strings) throws Exception {
        logger.info(">>>>>>>>>>>项目启动时，执行的操作：222222222222222");
    }
}
