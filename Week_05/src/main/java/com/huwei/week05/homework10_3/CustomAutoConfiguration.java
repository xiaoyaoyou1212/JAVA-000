package com.huwei.week05.homework10_3;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020-11-22 20:55
 * @FileName: CustomAutoConfiguration
 * Copyright (C), 2015-2020
 */
@Configuration
@ConditionalOnProperty(prefix = "school", value = "enabled", havingValue = "true")
public class CustomAutoConfiguration {
    @Bean
    public Student student1() {
        return new Student(1, "逍遥游");
    }

    @Bean
    public Student student2() {
        return new Student(2, "XYY");
    }

    @Bean
    @ConditionalOnBean(name = {"student1", "student2"})
    public Klass klass(Student student1, Student student2) {
        Klass klass = new Klass();
        klass.setStudents(Arrays.asList(student1, student2));
        return klass;
    }

    @Bean
    @ConditionalOnBean(name = "klass")
    public School school(Klass klass, Student student1) {
        School school = new School();
        school.setKlass(klass);
        school.setStudent(student1);
        return school;
    }
}
