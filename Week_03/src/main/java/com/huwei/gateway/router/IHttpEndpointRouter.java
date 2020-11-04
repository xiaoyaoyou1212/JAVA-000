package com.huwei.gateway.router;

import java.util.List;

/**
 * @Description: 路由接口
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/4 15:26
 * @FileName: IHttpEndpointRouter
 * Copyright (C), 2015-2020
 */
public interface IHttpEndpointRouter {
    String route(List<String> endpoints);
}
