package com.huwei.week05.homework9_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 测试 Spring Bean 的装配（第9课第2题作业）
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 11:47
 * @FileName: Test
 * Copyright (C), 2015-2020
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        XmlStudent xmlStudent = (XmlStudent) context.getBean("xmlStudent");
        System.out.println(xmlStudent.toString());

        AnnoStudent annoStudent = (AnnoStudent) context.getBean("annoStudent");
        System.out.println(annoStudent.toString());

        BeanStudent beanStudent = (BeanStudent) context.getBean("beanStudent");
        System.out.println(beanStudent.toString());
    }
}
