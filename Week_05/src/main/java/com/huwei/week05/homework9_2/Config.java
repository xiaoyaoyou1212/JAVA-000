package com.huwei.week05.homework9_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: Java 装配 Bean 的配置类
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 15:17
 * @FileName: Config
 * Copyright (C), 2015-2020
 */
@Configuration
public class Config {
    @Bean("beanStudent")
    public BeanStudent getBeanStudent() {
        return new BeanStudent(3, "逍遥游");
    }
}
