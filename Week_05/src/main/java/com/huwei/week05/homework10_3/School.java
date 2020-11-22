package com.huwei.week05.homework10_3;

import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020-11-22 20:50
 * @FileName: School
 * Copyright (C), 2015-2020
 */
@Service
public class School implements ISchool {
    private Student student;
    private Klass klass;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public void ding() {
        System.out.println("Klass have " + this.klass.getStudents().size() + " students and one is " + this.student);
    }
}
