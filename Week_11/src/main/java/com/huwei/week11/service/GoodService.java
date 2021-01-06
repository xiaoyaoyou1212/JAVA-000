package com.huwei.week11.service;

import com.huwei.week11.base.BaseTkService;
import com.huwei.week11.model.Good;

/**
 * @Description: 商品服务
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2021/1/6 11:25
 * @FileName: GoodService
 * Copyright (C), 2015-2021
 */
public interface GoodService extends BaseTkService<Good> {
    String buyGood(Integer goodId, Integer goodNum);
}
