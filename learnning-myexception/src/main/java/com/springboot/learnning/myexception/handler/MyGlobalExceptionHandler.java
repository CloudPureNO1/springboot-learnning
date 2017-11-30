package com.springboot.learnning.myexception.handler;

import com.springboot.learnning.myexception.domain.enums.ResultEnum;
import com.springboot.learnning.myexception.domain.exception.BaseException;
import com.springboot.learnning.myexception.domain.pojo.DataError;
import com.springboot.learnning.myexception.domain.pojo.ResultInfo;
import com.springboot.learnning.myexception.util.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import  java.util.Date;
import java.util.List;

/**
 * Created by CloudPure on 2017/11/30.
 */
@ControllerAdvice
public class MyGlobalExceptionHandler {



private static final Logger logger= Logger.getLogger(MyGlobalExceptionHandler.class);

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public ResultInfo getExceptionResultInfo(HttpServletRequest request,Exception e){
        StackTraceElement[] stackTraceElements= Thread.currentThread().getStackTrace();
        List<DataError>list=new ArrayList<DataError>();
        DataError dataError=null;
        int i=1;
        for(StackTraceElement se:stackTraceElements){
            i++;
            if(i>4&&!(se.getClassName()).startsWith("com.")) continue;
            dataError =new DataError();
            logger.info("INFO:类"+se.getClassName()+">>>方法："+se.getMethodName()+">>>行号："+se.getLineNumber());
            dataError.setClassName(se.getClassName());
            dataError.setMehtodName(se.getMethodName());
            dataError.setLineNumber(se.getLineNumber());
            dataError.setExceptionMsg(e.getMessage());
            list.add(dataError);

        }
        if(e instanceof BaseException){
             BaseException baseException= (BaseException) e;
             return ResultUtil.setResultInfo(baseException.getCode(),baseException.getMessage(),request.getRequestURI(),list,new Date());
        }else{
            logger.error("未定义的异常："+e.getMessage(),e);
            return ResultUtil.setResultInfo(-100,"未定义的异常："+e.getMessage(),request.getRequestURI(),list,new Date());
        }
    }


    public <T>ResultInfo<T> getResultInfo(T data, HttpServletRequest request){
            return ResultUtil.setResultInfo(ResultEnum.SUCCESS.getOrdinal(),ResultEnum.SUCCESS.getName(),request.getRequestURI(),data,new Date());
    }
}
