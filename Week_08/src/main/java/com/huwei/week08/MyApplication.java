package com.huwei.week08;

import com.huwei.week08.homework16_2.TransactionConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description: 应用启动类
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/9 17:28
 * @FileName: MyApplication
 * Copyright (C), 2015-2020
 */
@ComponentScan("com.huwei.week08.homework15_2")
@MapperScan(basePackages = "com.huwei.week08.homework15_2.dao")
@SpringBootApplication
@Import(TransactionConfiguration.class)
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
