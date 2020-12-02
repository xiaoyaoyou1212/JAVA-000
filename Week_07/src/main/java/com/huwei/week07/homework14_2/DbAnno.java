package com.huwei.week07.homework14_2;

import java.lang.annotation.*;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/2 17:36
 * @FileName: DbAnno
 * Copyright (C), 2015-2020
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DbAnno {
    boolean isMaster() default true;
}
