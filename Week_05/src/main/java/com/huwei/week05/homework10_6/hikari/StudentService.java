package com.huwei.week05.homework10_6.hikari;

/**
 * @Description: Service
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 16:18
 * @FileName: StudentService
 * Copyright (C), 2015-2020
 */
public interface StudentService {
    /**
     * 增
     * @param student
     * @return
     */
    Student add(Student student);

    /**
     * 删
     * @param id
     */
    void delete(Integer id);

    /**
     * 改
     * @param student
     * @return
     */
    Student update(Student student);

    /**
     * 查
     * @param id
     * @return
     */
    Student find(Integer id);
}
