package com.huwei.week04;

/**
 * @Description: 计算斐波拉契数列
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/11 17:42
 * @FileName: Fibo
 * Copyright (C), 2015-2020
 */
public class Fibo {
    private int value;

    public int getValue() {
        while (value == 0) {

        }
        return value;
    }

    public int sum(int a) {
        value = fibo(a);
        return value;
    }

    private int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}
