package com.huwei.week11.lock;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @Description: Redis锁
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2021/1/6 11:18
 * @FileName: RedisLock
 * Copyright (C), 2015-2021
 */
@Component
public class RedisLock {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加锁
     *
     * @param lockKey   加锁的Key
     * @param timeStamp 时间戳：当前时间+超时时间
     * @return
     */
    public boolean lock(String lockKey, String timeStamp) {
        if (stringRedisTemplate.opsForValue().setIfAbsent(lockKey, timeStamp)) {
            return true;
        }
        String currentLock = stringRedisTemplate.opsForValue().get(lockKey);
        if (!StringUtils.isEmpty(currentLock) && Long.parseLong(currentLock) < System.currentTimeMillis()) {
            String preLock = stringRedisTemplate.opsForValue().getAndSet(lockKey, timeStamp);
            if (!StringUtils.isEmpty(preLock) && preLock.equals(currentLock)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 释放锁
     *
     * @param lockKey
     * @param timeStamp
     */
    public void release(String lockKey, String timeStamp) {
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(lockKey);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(timeStamp)) {
                // 删除锁状态
                stringRedisTemplate.opsForValue().getOperations().delete(lockKey);
            }
        } catch (Exception e) {
            System.out.println("解锁异常");
        }
    }
}
