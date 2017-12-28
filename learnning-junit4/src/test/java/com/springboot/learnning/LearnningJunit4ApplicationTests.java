package com.springboot.learnning;

import com.springboot.learnning.service.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnningJunit4ApplicationTests {

	@Resource
	private TestService testService;
	@Test
	public void contextLoads() {
		Assert.assertEquals("沐2",testService.getName());
	}

}
