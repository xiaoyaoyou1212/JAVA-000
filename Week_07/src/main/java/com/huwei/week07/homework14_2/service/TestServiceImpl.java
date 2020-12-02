package com.huwei.week07.homework14_2.service;

import com.huwei.week07.homework14_2.DbAnno;
import com.huwei.week07.homework14_2.DbContext;
import com.huwei.week07.homework14_2.dao.TestDao;
import com.huwei.week07.homework14_2.mode.Test;
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

    @DbAnno
    @Override
    public Test getTest0(Integer id) {
        Test test = testDao.getTest(id);
        System.out.println("getTest0----DB:" + DbContext.getDb().get() + ",Attribute:" + test.getTitle() + ",Data:" + test.getDesc());
        return test;
    }

    @DbAnno(isMaster = false)
    @Override
    public Test getTest1(Integer id) {
        Test test = testDao.getTest(id);
        System.out.println("getTest1----DB:" + DbContext.getDb().get() + ",Attribute:" + test.getTitle() + ",Data:" + test.getDesc());
        return test;
    }

    @Override
    public Test getTest2(Integer id) {
        Test test = testDao.getTest(id);
        System.out.println("getTest2----DB:" + DbContext.getDb().get() + ",Attribute:" + test.getTitle() + ",Data:" + test.getDesc());
        return test;
    }
}
