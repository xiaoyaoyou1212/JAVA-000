package com.huwei.rpcfx.client;

import com.alibaba.fastjson.JSON;
import com.huwei.rpcfx.api.RpcfxRequest;
import com.huwei.rpcfx.api.RpcfxResponse;
import com.huwei.rpcfx.exception.RpcfxException;
import com.huwei.rpcfx.request.HttpClientRequest;
import com.huwei.rpcfx.request.IRequest;
import com.huwei.rpcfx.request.OkHttpClientRequest;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/17 14:00
 * @FileName: RpcfxHandler
 * Copyright (C), 2015-2020
 */
public class RpcfxHandler implements MethodInterceptor {
    private Class<?> serviceClass;
    private String url;
    private IRequest iRequest;

    public RpcfxHandler(Class<?> serviceClass, String url) {
        this.serviceClass = serviceClass;
        this.url = url;
        iRequest = new HttpClientRequest();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        RpcfxRequest request = new RpcfxRequest();
        request.setServiceClass(this.serviceClass.getName());
        request.setMethod(method.getName());
        request.setParams(params);

        RpcfxResponse response = iRequest.request(request, url);

        if (response.getException() instanceof RpcfxException) {
            System.out.println(((RpcfxException) response.getException()).toString());
        }

        // 这里判断response.status，处理异常
        // 考虑封装一个全局的RpcfxException

        return JSON.parse(response.getResult().toString());
    }
}
