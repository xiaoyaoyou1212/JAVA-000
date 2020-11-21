package com.huwei.week05.homework10_6.hikari;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: Controller
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 16:18
 * @FileName: StudentController
 * Copyright (C), 2015-2020
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    /**
     * 增
     *
     * @return
     */
    @RequestMapping("/add")
    public Student add() {
        Student student = new Student();
        student.setName("Hikari add");
        return studentService.add(student);
    }

    /**
     * 删
     *
     * @param id
     */
    @RequestMapping("/delete")
    public void delete(Integer id) {
        studentService.delete(id);
    }

    /**
     * 改
     *
     * @param id
     * @return
     */
    @RequestMapping("/update")
    public Student update(Integer id) {
        Student student = studentService.find(id);
        if (student != null) {
            student.setName("Hikari update");
        }
        return studentService.update(student);
    }

    /**
     * 查
     *
     * @param id
     * @return
     */
    @RequestMapping("/find")
    public Student find(Integer id) {
        return studentService.find(id);
    }
}
