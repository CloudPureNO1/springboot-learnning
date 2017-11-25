package com.springboot.learnning.domain.learnningdomain.pojo;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 1、@Component：把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
 2、@Autowired：Spring框架中进行对象注入
 */

@Component
@Configuration
public class MsgTest implements  java.io.Serializable{
    private String username;
    private String hello;
    private String greeting;
    private String discription;

    public MsgTest(String username, String hello, String greeting, String discription) {
        this.username = username;
        this.hello = hello;
        this.greeting = greeting;
        this.discription = discription;
    }
    public MsgTest(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MsgTest msgTest = (MsgTest) o;

        if (username != null ? !username.equals(msgTest.username) : msgTest.username != null) return false;
        if (hello != null ? !hello.equals(msgTest.hello) : msgTest.hello != null) return false;
        if (greeting != null ? !greeting.equals(msgTest.greeting) : msgTest.greeting != null) return false;
        return discription != null ? discription.equals(msgTest.discription) : msgTest.discription == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (hello != null ? hello.hashCode() : 0);
        result = 31 * result + (greeting != null ? greeting.hashCode() : 0);
        result = 31 * result + (discription != null ? discription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MsgTest{" +
                "username='" + username + '\'' +
                ", hello='" + hello + '\'' +
                ", greeting='" + greeting + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }
}
