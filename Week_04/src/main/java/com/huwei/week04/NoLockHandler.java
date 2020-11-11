package com.huwei.week04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        Fibo fibo = new Fibo();
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(() -> fibo.sum(36));
        int result = fibo.getValue(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
        exec.shutdown();
    }
}
