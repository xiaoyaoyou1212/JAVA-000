package com.huwei.week05.homework10_6.hikari;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description: DAO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 16:17
 * @FileName: StudentDao
 * Copyright (C), 2015-2020
 */
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
}
