package com.huwei.rpcfx.request;

import com.huwei.rpcfx.api.RpcfxRequest;
import com.huwei.rpcfx.api.RpcfxResponse;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/17 14:10
 * @FileName: IRequest
 * Copyright (C), 2015-2020
 */
public interface IRequest {
    RpcfxResponse request(RpcfxRequest request, String url);
}
