package com.huwei.week11.base;

import java.util.List;

/**
 * @Description: 数据操作基础服务
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2021/1/6 11:43
 * @FileName: BaseTkService
 * Copyright (C), 2015-2021
 */
public interface BaseTkService<T> {
    T selectByPrimaryKey(Object id);

    List<T> select(T t);

    List<T> selectAll();

    T selectOne(T t);

    int insert(T t);

    int insertSelective(T t);

    int updateByPrimaryKey(T t);

    int updateByPrimaryKeySelective(T t);

    int deleteByPrimaryKey(Object id);

    int delete(T t);
}
