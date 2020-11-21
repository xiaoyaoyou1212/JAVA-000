package com.huwei.week05.homework9_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;

/**
 * @Description: 注解方式创建 Bean
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 13:59
 * @FileName: AnnoStudent
 * Copyright (C), 2015-2020
 */
@Component("annoStudent")
public class AnnoStudent implements Serializable {
    @Value("2")
    private Integer id;
    @Value("逍遥游")
    private String name;

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
        return "AnnoStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void create(){
        System.out.println("Bean 初始化，创建 AnnoStudent");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Bean 销毁，销毁 AnnoStudent");
    }
}
