package com.huwei.week11.base;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Description: 数据操作基础服务实现
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2021/1/6 11:43
 * @FileName: BaseTkServiceImpl
 * Copyright (C), 2015-2021
 */
public abstract class BaseTkServiceImpl<T> implements BaseTkService<T> {
    public BaseTkServiceImpl() {
    }

    public abstract Mapper<T> getDao();

    @Override
    public T selectByPrimaryKey(Object id) {
        return this.getDao().selectByPrimaryKey(id);
    }

    @Override
    public List<T> select(T t) {
        return this.getDao().select(t);
    }

    @Override
    public List<T> selectAll() {
        return this.getDao().selectAll();
    }

    @Override
    public T selectOne(T t) {
        return this.getDao().selectOne(t);
    }

    @Override
    public int insert(T t) {
        return this.getDao().insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return this.getDao().insertSelective(t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return this.getDao().updateByPrimaryKey(t);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return this.getDao().updateByPrimaryKeySelective(t);
    }

    @Override
    public int deleteByPrimaryKey(Object id) {
        return this.getDao().deleteByPrimaryKey(id);
    }

    @Override
    public int delete(T t) {
        return this.getDao().delete(t);
    }
}
