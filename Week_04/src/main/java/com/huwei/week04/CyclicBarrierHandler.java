package com.huwei.week04;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: CyclicBarrier 处理
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/11 17:46
 * @FileName: CyclicBarrierHandler
 * Copyright (C), 2015-2020
 */
public class CyclicBarrierHandler {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        Fibo fibo = new Fibo();
        ExecutorService exec = Executors.newSingleThreadExecutor();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
        exec.execute(() -> {
            try {
                fibo.sum(36);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        cyclicBarrier.await();
        int result = fibo.getValue(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
        exec.shutdown();
    }
}
