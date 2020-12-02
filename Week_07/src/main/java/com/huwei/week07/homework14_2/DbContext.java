package com.huwei.week07.homework14_2;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/2 17:33
 * @FileName: DbContext
 * Copyright (C), 2015-2020
 */
public class DbContext {
    private static final ThreadLocal<Optional<DbType>> dbTypeEmThreadLocal = new ThreadLocal<>();
    private static final AtomicInteger atoCounter = new AtomicInteger(0);

    public static void setDb(DbType dbType) {
        dbTypeEmThreadLocal.set(Optional.ofNullable(dbType));
    }

    public static Optional<DbType> getDb() {
        return dbTypeEmThreadLocal.get();
    }

    public static void remove() {
        dbTypeEmThreadLocal.remove();
    }

    /**
     * 设置主从库
     *
     * @param isMaster
     */
    public static void setDb(boolean isMaster) {
        if (isMaster) {
            //主库
            setDb(DbType.DB_TYPE_MASTER);
        } else {
            //从库
            setSlave();
        }
    }

    private static void setSlave() {
        if (atoCounter.get() >= 10000) {
            atoCounter.set(0);
        }
        int slaveNum = atoCounter.getAndIncrement() % (DbType.values().length - 1);
        Optional<DbType> dbType = DbType.getDbTypeBySlaveNum(slaveNum);
        if (dbType.isPresent()) {
            setDb(dbType.get());
        } else {
            throw new IllegalArgumentException("从库未匹配");
        }
    }
}
