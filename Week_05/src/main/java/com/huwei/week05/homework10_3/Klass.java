package com.huwei.week05.homework10_3;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020-11-22 20:50
 * @FileName: Klass
 * Copyright (C), 2015-2020
 */
public class Klass implements Serializable {
    List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
