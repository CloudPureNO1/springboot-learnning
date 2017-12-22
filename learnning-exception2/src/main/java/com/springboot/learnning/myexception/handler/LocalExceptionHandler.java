package com.springboot.learnning.myexception.handler;

import com.springboot.learnning.myexception.domain.ExceptionData;
import com.springboot.learnning.myexception.domain.ResultInfo;
import com.springboot.learnning.myexception.domain.enums.ExceptionEnum;
import com.springboot.learnning.myexception.domain.exception.BaseException;
import com.springboot.learnning.myexception.util.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by CloudPure on 2017/12/21.
 */
@ControllerAdvice
public class LocalExceptionHandler {
private static final Logger logger= Logger.getLogger(LocalExceptionHandler.class);

   @ExceptionHandler(value=Exception.class)
   @ResponseBody
    public ResultInfo localErrorHandler(HttpServletRequest request,Exception e) throws BaseException {

       ResultInfo  resultInfo=null;
       List<ExceptionData> list=new ArrayList<ExceptionData>();
       ExceptionData exceptionData=null;
       StackTraceElement [] stackTraceElements=e.getStackTrace();
       for(StackTraceElement st:stackTraceElements){
           exceptionData=new ExceptionData();
            if(!(st.getClassName()).startsWith("com.springboot.learnning.")) continue;
               exceptionData.setClassName(st.getClassName());
               exceptionData.setMethodName(st.getMethodName());
               exceptionData.setLineNumber(st.getLineNumber());
               exceptionData.setExceptionMsg(e.toString());
            list.add(exceptionData);
       }
       String s=e.getClass().getName();
       int ijs=s.lastIndexOf(".");
       s=s.substring(ijs+1);
       if(e instanceof BaseException){//是否是已经定义的异常
            BaseException baseException= (BaseException) e;
            resultInfo=ResultUtil.getResult(baseException.getCode(),baseException.toString(),request.getRequestURI(),list);
       }else if(ExceptionEnum.getOrdinal(s)!=ExceptionEnum.ENUM_TRANSLATION_EXCEPTION.getOrdinal()){
           resultInfo=ResultUtil.getResult(ExceptionEnum.getOrdinal(s),ExceptionEnum.getName(s),request.getRequestURI(),list);
       }else {
           resultInfo=ResultUtil.getResult(ExceptionEnum.UndefindeException.getOrdinal(),e.toString(),request.getRequestURI(),list);
       }
        return resultInfo;
    }


}
