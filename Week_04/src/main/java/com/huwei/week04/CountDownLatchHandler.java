package com.huwei.week04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: CountDownLatch 处理
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/11 16:47
 * @FileName: CountDownLatchHandler
 * Copyright (C), 2015-2020
 */
public class CountDownLatchHandler {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        Fibo fibo = new Fibo();
        ExecutorService exec = Executors.newSingleThreadExecutor();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        exec.execute(() -> {
            try {
                fibo.sum(36);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        int result = fibo.getValue(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
        exec.shutdown();
    }

}
