package com.huwei.week05.homework9_2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;

/**
 * @Description: Java代码创建 Bean
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 13:59
 * @FileName: BeanStudent
 * Copyright (C), 2015-2020
 */
public class BeanStudent implements Serializable, InitializingBean, DisposableBean {
    private Integer id;
    private String name;

    public BeanStudent(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean 初始化，创建 BeanStudent");
    }

    @Override
    public void destroy(){
        System.out.println("Bean 销毁，销毁 BeanStudent");
    }
}
