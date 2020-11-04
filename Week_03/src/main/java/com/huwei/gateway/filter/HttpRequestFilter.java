package com.huwei.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.List;
import java.util.Map;

/**
 * @Description: 请求过滤器
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/4 19:22
 * @FileName: HttpRequestFilter
 * Copyright (C), 2015-2020
 */
public class HttpRequestFilter implements IHttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        System.out.println("===================================HttpRequestFilter======================================");
        if (fullRequest != null && fullRequest.headers() != null) {
            List<Map.Entry<String, String>> entries = fullRequest.headers().entries();
            if (entries != null && !entries.isEmpty()) {
                for (Map.Entry<String, String> entry : entries) {
                    if (entry != null) {
                        System.out.println("request head--key:" + entry.getKey() + ",value:" + entry.getValue());
                    }
                }
                fullRequest.headers().add("nio", "huwei");
            }
        }
    }
}
