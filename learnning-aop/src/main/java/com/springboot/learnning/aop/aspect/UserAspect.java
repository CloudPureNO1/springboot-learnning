package com.springboot.learnning.aop.aspect;

import com.springboot.learnning.aop.annotation.UserAnnotation;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by CloudPure on 2018/1/8.
 */
@Aspect
@Component
public class UserAspect {
    private static final Logger logger= Logger.getLogger(UserAspect.class);
    @Pointcut("@annotation(com.springboot.learnning.aop.annotation.UserAnnotation)")
    public void userLog(){}

    @Before("userLog()")
    public void before(JoinPoint joinPoint){
        logger.info("》》》》》》》》》》》》》》》方法："+joinPoint.getSignature().getDeclaringType()+"."+joinPoint.getSignature().getName());
    }


    @Around("@annotation(annotationArgs)")
    public Object arround(ProceedingJoinPoint pjp, UserAnnotation annotationArgs){
        Object obj=null;
        try {
            obj =pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info(">>>>>>>>>>>>>>>>>>>>方法环绕proceed，结果是 :" +obj);
        logger.info(">>>>>>>>>>>>>>>>>>>>注解里的值 :" +annotationArgs);
        return obj;
    }
}
