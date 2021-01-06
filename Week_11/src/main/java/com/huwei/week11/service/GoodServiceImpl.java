package com.huwei.week11.service;

import com.huwei.week11.base.BaseTkServiceImpl;
import com.huwei.week11.dao.GoodDao;
import com.huwei.week11.lock.RedisLock;
import com.huwei.week11.model.Good;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

/**
 * @Description: 商品服务实现
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2021/1/6 11:25
 * @FileName: GoodServiceImpl
 * Copyright (C), 2015-2021
 */
@Service
public class GoodServiceImpl extends BaseTkServiceImpl<Good> implements GoodService {
    @Resource
    private GoodDao goodDao;
    @Resource
    private RedisLock redisLock;

    /**
     * 超时时间 5s
     */
    private static final int TIMEOUT = 5 * 1000;

    @Override
    public Mapper<Good> getDao() {
        return goodDao;
    }

    @Override
    public String buyGood(Integer goodId, Integer goodNum) {
        //上锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(String.valueOf(goodId), String.valueOf(time))) {
            return "排队人数太多，请稍后再试.";
        }
        System.out.println("获得锁的时间戳：" + time);
        try {
            Good good = selectByPrimaryKey(goodId);
            if (good != null) {
                if (good.getGoodStock() <= 0) {
                    return "对不起，卖完了，库存为：" + good.getGoodStock();
                }
                if (good.getGoodStock() < goodNum) {
                    return "对不起，库存不足，库存为：" + good.getGoodStock() + " 您的购买数量为：" + goodNum;
                }
                System.out.println("剩余库存：" + good.getGoodStock());
                System.out.println("扣除库存：" + goodNum);
                //更新商品库存
                updateGoodStock(good, goodNum);
                try {
                    //为了更好的测试多线程同时进行库存扣减，在进行数据更新之后先等1秒，让多个线程同时竞争资源
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "恭喜您，购买成功！";
            } else {
                return "获取库存失败。";
            }
        } finally {
            //释放锁
            redisLock.release(String.valueOf(goodId), String.valueOf(time));
            System.out.println("释放锁的时间戳：" + time);
        }
    }

    @Transactional
    void updateGoodStock(Good good, Integer goodNum) {
        good.setGoodStock(good.getGoodStock() - goodNum);
        updateByPrimaryKey(good);
    }
}
