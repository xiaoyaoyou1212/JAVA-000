package com.huwei.rpcfx.client;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/17 13:56
 * @FileName: RpcfxClient
 * Copyright (C), 2015-2020
 */
public interface RpcfxClient {
    <T> T create(final Class<T> serviceClass, final String url);
}
