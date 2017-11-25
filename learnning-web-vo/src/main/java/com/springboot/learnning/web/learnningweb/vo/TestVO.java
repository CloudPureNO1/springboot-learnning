package com.springboot.learnning.web.learnningweb.vo;

import org.springframework.stereotype.Component;

@Component
public class TestVO {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "TestVO{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
