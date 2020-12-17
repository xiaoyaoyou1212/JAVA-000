package com.huwei.rpcfx.exception;

/**
 * @Description: 自定义异常
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/16 17:24
 * @FileName: RpcfxException
 * Copyright (C), 2015-2020
 */
public class RpcfxException extends Exception {
    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public RpcfxException(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "RpcfxException{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                "} " + super.toString();
    }
}
