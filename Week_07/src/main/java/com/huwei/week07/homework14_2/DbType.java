package com.huwei.week07.homework14_2;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/2 16:56
 * @FileName: DbType
 * Copyright (C), 2015-2020
 */
public enum DbType {

    DB_TYPE_MASTER(0, "db0", -1),
    DB_TYPE_SLAVE0(1, "db1", 0),
    DB_TYPE_SLAVE1(2, "db2", 1);

    private int code;
    private String desc;
    private int slaveNum;

    DbType(int code, String desc, int slaveNum) {
        this.code = code;
        this.desc = desc;
        this.slaveNum = slaveNum;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public int getSlaveNum() {
        return slaveNum;
    }

    public static Optional<DbType> getDbTypeBySlaveNum(int slaveNum) {
        return Arrays.stream(DbType.values()).filter(dbType -> dbType.getSlaveNum() == slaveNum).findFirst();
    }
}
