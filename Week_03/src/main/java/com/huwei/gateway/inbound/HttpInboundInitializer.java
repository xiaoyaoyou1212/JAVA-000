package com.huwei.gateway.inbound;

import com.huwei.gateway.filter.IHttpRequestFilter;
import com.huwei.gateway.router.IHttpEndpointRouter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.ssl.SslContext;

import java.util.List;

/**
 * @Description: 服务初始化
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/4 15:09
 * @FileName: HttpInboundInitializer
 * Copyright (C), 2015-2020
 */
public class HttpInboundInitializer extends ChannelInitializer<SocketChannel> {
    private final SslContext sslCtx;
    private final List<String> proxyServers;
    private IHttpRequestFilter filter;
    private IHttpEndpointRouter router;

    public HttpInboundInitializer(SslContext sslCtx, List<String> proxyServers) {
        this.sslCtx = sslCtx;
        this.proxyServers = proxyServers;
    }

    public void setFilter(IHttpRequestFilter filter) {
        this.filter = filter;
    }

    public void setRouter(IHttpEndpointRouter router) {
        this.router = router;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();
        if (sslCtx != null) {
            p.addLast(sslCtx.newHandler(ch.alloc()));
        }
        p.addLast(new HttpServerCodec());
        //p.addLast(new HttpServerExpectContinueHandler());
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        if (proxyServers != null && !proxyServers.isEmpty()) {
            HttpInboundHandler httpInboundHandler;
            if (router != null) {
                httpInboundHandler = new HttpInboundHandler(router.route(proxyServers));
            } else {
                httpInboundHandler = new HttpInboundHandler(proxyServers.get(0));
            }
            if (filter != null) {
                httpInboundHandler.setFilter(filter);
            }
            p.addLast(httpInboundHandler);
        }
    }
}
