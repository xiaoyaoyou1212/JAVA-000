package com.huwei.rpcfx.request;

import com.alibaba.fastjson.JSON;
import com.huwei.rpcfx.api.RpcfxRequest;
import com.huwei.rpcfx.api.RpcfxResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/17 14:11
 * @FileName: OkHttpClientRequest
 * Copyright (C), 2015-2020
 */
public class OkHttpClientRequest implements IRequest {
    private static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

    @Override
    public RpcfxResponse request(RpcfxRequest req, String url) {
        String reqJson = JSON.toJSONString(req);
        System.out.println("req json: " + reqJson);
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSONTYPE, reqJson))
                .build();
        String respJson = null;
        try {
            respJson = client.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("resp json: " + respJson);
        return JSON.parseObject(respJson, RpcfxResponse.class);
    }
}
