package com.huwei.week07.homework14_3.service;

import com.huwei.week07.homework14_3.dao.TestDao;
import com.huwei.week07.homework14_3.mode.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/2 17:47
 * @FileName: TestServiceImpl
 * Copyright (C), 2015-2020
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestDao testDao;

    @Override
    public Test getTest0(Integer id) {
        Test test = testDao.getTest(id);
        return test;
    }

    @Override
    public Test getTest1(Integer id) {
        Test test = testDao.getTest(id);
        return test;
    }

    @Override
    public Test getTest2(Integer id) {
        Test test = testDao.getTest(id);
        return test;
    }
}
