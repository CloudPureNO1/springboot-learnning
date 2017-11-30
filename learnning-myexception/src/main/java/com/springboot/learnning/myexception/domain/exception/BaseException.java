package com.springboot.learnning.myexception.domain.exception;

import com.springboot.learnning.myexception.domain.enums.ResultEnum;

/**
 * Created by CloudPure on 2017/11/30.
 */
public class BaseException extends Exception{
    private int code;

    public BaseException(ResultEnum resultEnum){
        super(resultEnum.getName());
        this.code=resultEnum.getOrdinal();
    }

    public BaseException(String name,int ordinal){
        super(name);
        this.code=ordinal;
    }

    public int  getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
