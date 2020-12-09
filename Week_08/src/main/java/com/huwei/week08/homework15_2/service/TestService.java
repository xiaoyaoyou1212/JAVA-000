package com.huwei.week08.homework15_2.service;

import com.huwei.week08.homework15_2.mode.Test;

/**
 * @Description: 服务接口
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/2 17:47
 * @FileName: TestService
 * Copyright (C), 2015-2020
 */

public interface TestService {
    int insert(Test t);

    int deleteByPrimaryKey(Object id);

    int updateByPrimaryKey(Test t);

    Test selectByPrimaryKey(Object id);

}
