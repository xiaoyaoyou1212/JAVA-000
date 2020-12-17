package com.huwei.dubbo.demo.provider;

import com.huwei.dubbo.demo.api.Account;
import com.huwei.dubbo.demo.api.AccountService;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/17 15:58
 * @FileName: AccountServiceImpl
 * Copyright (C), 2015-2020
 */
@DubboService(version = "1.0.0")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    private static AtomicInteger confrimCount = new AtomicInteger(0);

    @Override
    public Account findByUserId(String userId) {
        return accountMapper.findByUserId(userId);
    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean payment(String userId, BigDecimal amount) {
        return accountMapper.update(userId, amount) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean confirm(String userId, BigDecimal amount) {
        System.out.println("============dubbo tcc 执行确认付款接口===============");
        accountMapper.confirm(userId, amount);
        final int i = confrimCount.incrementAndGet();
        System.out.println("调用了account confirm " + i + " 次");
        return Boolean.TRUE;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(String userId, BigDecimal amount) {
        System.out.println("============ dubbo tcc 执行取消付款接口===============");
        final Account account = accountMapper.findByUserId(userId);
        accountMapper.cancel(userId, amount);
        return Boolean.TRUE;
    }
}
