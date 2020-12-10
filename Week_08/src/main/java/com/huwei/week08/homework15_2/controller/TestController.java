package com.huwei.week08.homework15_2.controller;

import com.huwei.week08.homework15_2.mode.Test;
import com.huwei.week08.homework15_2.service.TestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 控制层
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/2 19:15
 * @FileName: TestController
 * Copyright (C), 2015-2020
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private TestService testService;

    @PostMapping("/add")
    public Object add(String title, String name) {
        Test test = new Test();
        test.setTitle(title);
        test.setName(name);
        return testService.insert(test);
    }

    @DeleteMapping("/delete")
    public Object delete(Integer id) {
        return testService.deleteByPrimaryKey(id);
    }

    @PostMapping("/update")
    public Object update(Integer id, String title, String name) {
        Test test = testService.selectByPrimaryKey(id);
        if (test != null) {
            test.setTitle(title);
            test.setName(name);
        }
        return testService.updateByPrimaryKey(test);
    }

    @GetMapping("/get")
    public Object get(Integer id) {
        return testService.selectByPrimaryKey(id);
    }

}
