package com.springboot.learnning.junit4;


import com.springboot.learnning.LearnningJunit4Application;
import com.springboot.learnning.service.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= LearnningJunit4Application.class)
public class ServiceTest {
    @Resource
    private TestService testService;

    @Test
    public void test(){
        Assert.assertEquals("沐1",testService.getName());
    }
}
