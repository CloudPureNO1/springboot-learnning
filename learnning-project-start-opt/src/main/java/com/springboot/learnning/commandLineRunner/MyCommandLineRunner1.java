package com.springboot.learnning.commandLineRunner;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by CloudPure on 2017/12/28.
 * 在项目启动时，希望处理一些事情，或加载一些数据，
 * springboot中可以实现CommandLineRunner 接口
 *
 * 启动时，会加载所有实现CommandLineRunner接口的类的 run 方法，
 * 可以通过@Order(或者实现Order接口),来决定执行顺序
 * 数字小的，有限执行
 */
@Component
@Order(value=1)
public class MyCommandLineRunner1 implements CommandLineRunner {
    private static final Logger logger= Logger.getLogger(MyCommandLineRunner1.class);
    @Override
    public void run(String... strings) throws Exception {
        logger.info(">>>>>>>>>>开始处理：1111111111111111111111111");
    }
}
