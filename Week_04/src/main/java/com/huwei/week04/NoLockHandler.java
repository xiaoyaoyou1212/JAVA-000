package com.huwei.week04;

/**
 * @Description: 无锁处理
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/11 17:48
 * @FileName: NoLockHandler
 * Copyright (C), 2015-2020
 */
public class NoLockHandler {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        NoLockHandler noLockHandler = new NoLockHandler();
        Thread thread = new Thread(() -> {
            noLockHandler.sum(36);
        });
        thread.start();
        int result = noLockHandler.getValue(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    private volatile Integer value = null;

    public void sum(int num) {
        value = fibo(num);
    }

    private int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

    public int getValue() {
        while (value == null) {
        }
        return value;
    }

}
