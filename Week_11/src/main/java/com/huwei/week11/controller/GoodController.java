package com.huwei.week11.controller;

import com.huwei.week11.model.Good;
import com.huwei.week11.service.GoodService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @Description: 商品控制层
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2021/1/6 11:32
 * @FileName: GoodController
 * Copyright (C), 2015-2021
 */
@RestController
@RequestMapping("/good")
public class GoodController {
    @Resource
    private GoodService goodService;
    private Integer countNum = 0;

    @PostMapping("/insert")
    public void insert(Good good) {
        goodService.insert(good);
    }

    @DeleteMapping("/delete")
    public void delete(Good good) {
        goodService.delete(good);
    }

    @PostMapping("/update")
    public void update(Good good) {
        goodService.updateByPrimaryKey(good);
    }

    @GetMapping("/select")
    public Good select(Integer goodId) {
        return goodService.selectByPrimaryKey(goodId);
    }

    @GetMapping("/selectAll")
    public List<Good> selectAll() {
        return goodService.selectAll();
    }

    @GetMapping("/bugGood")
    public String bugGood() {
        for (int i = 0; i < 100; i++) {
            int count = 10;
            new Thread(() -> {
                String result = goodService.buyGood(1, count);
                System.out.println(result);
                if(!StringUtils.isEmpty(result) && result.indexOf("恭喜您，购买成功") != -1){
                    countNum += count;
                }
                if (countNum > 0) {
                    System.out.println("总共卖出："+countNum);
                }
            }).start();
        }
        return "购买成功";
    }
}
