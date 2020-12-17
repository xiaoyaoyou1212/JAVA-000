package com.huwei.dubbo.demo.api;

import org.dromara.hmily.annotation.Hmily;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/17 15:51
 * @FileName: AccountService
 * Copyright (C), 2015-2020
 */
public interface AccountService {
    /**
     * 获取用户账户信息
     *
     * @param userId 用户id
     * @return
     */
    Account findByUserId(String userId);

    /**
     * 扣款支付
     *
     * @param userId 用户id
     * @param amount 扣款金额
     */
    @Hmily
    boolean payment(String userId, BigDecimal amount);
}
