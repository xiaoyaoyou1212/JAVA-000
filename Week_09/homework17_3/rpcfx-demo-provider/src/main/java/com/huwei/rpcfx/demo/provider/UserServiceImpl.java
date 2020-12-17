package com.huwei.rpcfx.demo.provider;

import com.huwei.rpcfx.demo.api.User;
import com.huwei.rpcfx.demo.api.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "User" + System.currentTimeMillis());
    }
}
