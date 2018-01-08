package com.springboot.learnning.aop.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by CloudPure on 2018/1/8.
 */
@Aspect
@Component
public class WebLogAspect {
    private static final Logger logger= Logger.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.springboot.learnning.aop.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request=servletRequestAttributes.getRequest();
        logger.info("before>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info("request URL>>>>>>>>>>>>>>>>>>>>"+request.getRequestURI());
        logger.info("HTTP_METHOD>>>>>>>>>>"+request.getMethod());
        logger.info("IP>>>>>>>>>>>>>>>>>>"+request.getRemoteAddr());
        logger.info("CLASS_METHOD >>>>>>>>>>"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("ServerName>>>>>>>>>>>>>"+request.getServerName());
        logger.info("args>>>>>>>>>>>>>>"+joinPoint.getArgs());
    }

    @After("webLog()")
    public void after(JoinPoint joinPoint){
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>方法最后执行>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @AfterThrowing(throwing = "ex",pointcut = "webLog()")
    public void throwLog(JoinPoint joinPoint,Exception ex){
        logger.info(">>>>>>>>>>>>>>>>>>抛出异常日志>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ex.toString());
    }


    @AfterReturning(returning = "returnObject",pointcut = "webLog()")
    public void afterReturn(Object returnObject){
        logger.info(">>>>>>>>>>>>>>>>方法的返回值："+returnObject);
    }


    @Around("webLog()")
    public Object arround(ProceedingJoinPoint proceedingJoinPoint){
        Object obj=null;
        try {
           obj =proceedingJoinPoint.proceed();
            logger.info(">>>>>>>>>>>>>>>>>>>>方法环绕proceed，结果是 :" +obj);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
            return obj;
    }
}
