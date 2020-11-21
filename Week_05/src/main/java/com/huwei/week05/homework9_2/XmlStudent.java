package com.huwei.week05.homework9_2;

import java.io.Serializable;

/**
 * @Description: XML 方式创建 Bean
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 13:59
 * @FileName: XmlStudent
 * Copyright (C), 2015-2020
 */
public class XmlStudent implements Serializable {
    private Integer id;
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
        return "XmlStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void create(){
        System.out.println("Bean 初始化，创建 XmlStudent");
    }

    public void destroy(){
        System.out.println("Bean 销毁，销毁 XmlStudent");
    }
}
