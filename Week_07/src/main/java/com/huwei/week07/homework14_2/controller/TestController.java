package com.huwei.week07.homework14_2.controller;

import com.huwei.week07.homework14_2.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: TODO
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

    @GetMapping("/getTest0")
    public Object getTest0(Integer id) {
        return testService.getTest0(id);
    }

    @GetMapping("/getTest1")
    public Object getTest1(Integer id) {
        return testService.getTest1(id);
    }

    @GetMapping("/getTest2")
    public Object getTest2(Integer id) {
        return testService.getTest2(id);
    }
}
