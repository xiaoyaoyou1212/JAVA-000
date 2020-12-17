package com.huwei.dubbo.demo.provider;

import com.huwei.dubbo.demo.api.User;
import com.huwei.dubbo.demo.api.UserService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "User" + System.currentTimeMillis());
    }
}
