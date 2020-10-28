package com.huwei.week02.nio;

/**
 * @Description: Netty服务启动
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @FileName: NettyServerApplication
 * Copyright (C), 2015-2020
 */
public class NettyServerApplication {
    public static void main(String[] args) {
        HttpServer server = new HttpServer(false,8801);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
