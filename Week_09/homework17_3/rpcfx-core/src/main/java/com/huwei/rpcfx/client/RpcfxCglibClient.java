package com.huwei.rpcfx.client;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/17 13:57
 * @FileName: RpcfxCglibClient
 * Copyright (C), 2015-2020
 */
public class RpcfxCglibClient implements RpcfxClient {
    @Override
    public <T> T create(Class<T> serviceClass, String url) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new RpcfxHandler(serviceClass, url));
        enhancer.setSuperclass(serviceClass);
        return (T) enhancer.create();
    }

}
