package com.huwei.gateway;

import com.huwei.gateway.inbound.HttpInboundServer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Netty服务启动
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @FileName: NettyServerApplication
 * Copyright (C), 2015-2020
 */
public class NettyServerApplication {

    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "1.0.0";
    public final static Integer port = 8888;

    public static void main(String[] args) {
        List<String> proxyServers = new ArrayList<>();
        proxyServers.add("http://www.huwei.tech");
        proxyServers.add("http://www.baidu.com");
        proxyServers.add("http://www.zhihu.com");
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        HttpInboundServer server = new HttpInboundServer(false, port, proxyServers);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
