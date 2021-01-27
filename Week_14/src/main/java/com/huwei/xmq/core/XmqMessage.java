package com.huwei.xmq.core;

import java.util.HashMap;

public class XmqMessage<T> {
    private HashMap<String, Object> headers;

    private T body;

    public XmqMessage(HashMap<String, Object> headers, T body) {
        this.headers = headers;
        this.body = body;
    }

    public HashMap<String, Object> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, Object> headers) {
        this.headers = headers;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
