package com.huwei.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * @Description: 路由
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/4 19:22
 * @FileName: HttpEndpointRouter
 * Copyright (C), 2015-2020
 */
public class HttpEndpointRouter implements IHttpEndpointRouter {
    @Override
    public String route(List<String> endpoints) {
        if (endpoints == null || endpoints.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(endpoints.size());
        String routeUrl = endpoints.get(index);
        System.out.println("路由地址：" + routeUrl);
        return routeUrl;
    }
}
