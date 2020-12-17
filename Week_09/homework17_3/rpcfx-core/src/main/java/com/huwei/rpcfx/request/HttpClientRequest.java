package com.huwei.rpcfx.request;

import com.alibaba.fastjson.JSON;
import com.huwei.rpcfx.api.RpcfxRequest;
import com.huwei.rpcfx.api.RpcfxResponse;
import com.huwei.rpcfx.exception.RpcfxException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/17 14:11
 * @FileName: HttpClientRequest
 * Copyright (C), 2015-2020
 */
public class HttpClientRequest implements IRequest {
    @Override
    public RpcfxResponse request(RpcfxRequest req, String url) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        RpcfxResponse rpcfxResponse = new RpcfxResponse();
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            String reqJson = JSON.toJSONString(req);
            StringEntity entity = new StringEntity(reqJson, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            if (response != null) {
                resultString = EntityUtils.toString(response.getEntity(), "utf-8");
                rpcfxResponse = JSON.parseObject(resultString, RpcfxResponse.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rpcfxResponse.setStatus(false);
            rpcfxResponse.setException(new RpcfxException(-1, e.toString()));
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                rpcfxResponse.setStatus(false);
                rpcfxResponse.setException(new RpcfxException(-1, e.toString()));
            }
        }
        return rpcfxResponse;
    }
}
