package com.springboot.learnning.myexception.domain.exception;

import com.springboot.learnning.myexception.domain.enums.ExceptionEnum;

/**
 * Created by CloudPure on 2017/12/22.
 */
public class BaseException extends Exception{
    private int code;
    public BaseException(){
        super();
    }


    public BaseException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getName());
        this.code=exceptionEnum.getOrdinal();
    }

    public BaseException(int code ,String name){
        super(name);
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
