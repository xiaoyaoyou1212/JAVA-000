package com.huwei.week07.homework14_2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/2 17:33
 * @FileName: DbInterceptor
 * Copyright (C), 2015-2020
 */
@Aspect
@Component
public class DbInterceptor {
    private final String pointcut = "execution(* com.huwei.week07.homework14_2.service..*.*(..))";

    @Pointcut(value = pointcut)
    public void dbType() {
    }

    @Before("dbType()")
    void before(JoinPoint joinPoint) {
        System.out.println("before...");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        DbAnno dbAnno = method.getAnnotation(DbAnno.class);
        DbContext.setDb(dbAnno == null ? false : dbAnno.isMaster());
    }

    @After("dbType()")
    void after() {
        System.out.println("after...");
        DbContext.remove();
    }
}
