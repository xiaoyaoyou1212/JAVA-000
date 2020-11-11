package com.huwei.week04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: Lock Condition 处理
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/11 17:47
 * @FileName: LockConditionHandler
 * Copyright (C), 2015-2020
 */
public class LockConditionHandler {
    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        LockConditionHandler lockConditionHandler = new LockConditionHandler();
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(() -> lockConditionHandler.sum(36));
        int result = lockConditionHandler.getValue(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
        exec.shutdown();
    }

    private volatile int value;
    private Lock lock = new ReentrantLock();
    private Condition calComplete = lock.newCondition();

    public void sum(int num) {
        lock.lock();
        try {
            Fibo fibo = new Fibo();
            value = fibo.sum(num);
            calComplete.signal();
        } finally {
            lock.unlock();
        }
    }

    public int getValue() throws InterruptedException {
        lock.lock();
        try {
            while (value == 0) {
                calComplete.await();
            }
        } finally {
            lock.unlock();
        }
        return value;
    }
}
