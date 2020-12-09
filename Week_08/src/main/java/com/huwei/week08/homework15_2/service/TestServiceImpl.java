package com.huwei.week08.homework15_2.service;

import com.huwei.week08.homework15_2.dao.TestDao;
import com.huwei.week08.homework15_2.mode.Test;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @Description: 服务实现
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

    @Transactional(rollbackFor = SQLException.class)
    @ShardingTransactionType(TransactionType.XA)
    @Override
    public int insert(Test t) {
        return testDao.insert(t);
    }

    @Override
    public int deleteByPrimaryKey(Object id) {
        return testDao.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Test t) {
        return testDao.updateByPrimaryKey(t);
    }

    @Override
    public Test selectByPrimaryKey(Object id) {
        return testDao.selectByPrimaryKey(id);
    }
}
