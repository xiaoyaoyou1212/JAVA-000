package com.huwei.week05.homework10_6.hikari;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description: Service 实现
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 16:18
 * @FileName: StudentServiceImpl
 * Copyright (C), 2015-2020
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student add(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public Student update(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(Integer id) {
        return studentDao.getOne(id);
    }
}
