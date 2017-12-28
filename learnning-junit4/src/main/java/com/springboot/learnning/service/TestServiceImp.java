package com.springboot.learnning.service;

import org.springframework.stereotype.Service;

/**
 * Created by CloudPure on 2017/12/28.
 */
@Service(value="testService")
public class TestServiceImp implements TestService {
    @Override
    public String getName() {
        return "沐";
    }
}
