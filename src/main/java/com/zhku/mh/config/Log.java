package com.zhku.mh.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-08 09:51
 */
@Component
@Aspect
public class Log {
    @Pointcut("execution(* com.zhku.mh.dao.*.*(..))")
    public void pc1(){}

    @Around("pc1()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        long begin = System.nanoTime();
        Object obj = joinPoint.proceed();
        long end = System.nanoTime();
        long mtime = (end - begin) / 1000000;
        System.out.println("调用方法：{"+ joinPoint.getSignature().toString() +"}"
                +"参数：{"+ Arrays.toString(joinPoint.getArgs()) +"}"
                +"耗时：{"+mtime+"ms}");
        return obj;
    }
}
