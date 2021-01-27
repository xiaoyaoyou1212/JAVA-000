package com.huwei.xmq.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Xmq {
    private String topic;

    private int capacity;

    private LinkedBlockingQueue<XmqMessage> queue;

    public Xmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new LinkedBlockingQueue(capacity);
    }

    public boolean send(XmqMessage message) {
        return queue.offer(message);
    }

    public XmqMessage poll() {
        return queue.poll();
    }

    public XmqMessage poll(long timeout) throws InterruptedException {
        return queue.poll(timeout, TimeUnit.MILLISECONDS);
    }
}
