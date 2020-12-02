package com.huwei.week07.homework14_2;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/2 17:08
 * @FileName: DbRoute
 * Copyright (C), 2015-2020
 */
public class DbRoute extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContext.getDb().orElse(DbType.DB_TYPE_MASTER);
    }
}
