package com.huwei.week07.homework14_2.dao;

import com.huwei.week07.homework14_2.mode.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/2 17:48
 * @FileName: TestDao
 * Copyright (C), 2015-2020
 */
@Mapper
public interface TestDao {
    @Select("select * from tb_test where id = #{id}")
    Test getTest(Integer id);
}
