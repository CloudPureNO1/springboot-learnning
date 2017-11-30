package com.springboot.learnning.myexception;

import org.junit.runners.JUnit4;

/**
 * Created by CloudPure on 2017/11/30.
 */

public class Test {
    public static void main(String [] args){
        int i=22;
        Integer integer=22;

        System.out.println(i==integer);
        System.out.println(i==integer.intValue());
    }
}