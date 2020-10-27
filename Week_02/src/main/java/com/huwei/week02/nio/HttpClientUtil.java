package com.huwei.week02.nio;

import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @FileName: HttpClientUtil
 * Copyright (C), 2015-2020
 */
public class HttpClientUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    private static RequestConfig requestConfig = null;

    static {
        // 设置请求和传输超时时间
        requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
    }

    public static void main(String[] args) {
        String result = httpPost("http://localhost:8801/hello", null);
        System.out.println(result);
    }

    /**
     * post请求传输json参数
     *
     * @param url       url地址
     * @param param
     * @return
     */
    public static String httpPost(String url, String param) {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        httpPost.setConfig(requestConfig);
        try {
            if (null != param) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(param, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
            // 请求发送成功，并得到响应
            if (closeableHttpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(closeableHttpResponse.getEntity(), "utf-8");
                    return str;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpPost.releaseConnection();
        }
        return result;
    }

}
