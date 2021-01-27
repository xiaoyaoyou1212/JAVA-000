package com.huwei.xmq.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XmqBroker {
    public static final int CAPACITY = 10000;

    private final Map<String, Xmq> xmqMap = new ConcurrentHashMap<>(64);

    public void createTopic(String name) {
        xmqMap.putIfAbsent(name, new Xmq(name, CAPACITY));
    }

    public Xmq findXmq(String topic) {
        return this.xmqMap.get(topic);
    }

    public XmqProducer createProducer() {
        return new XmqProducer(this);
    }

    public XmqConsumer createConsumer() {
        return new XmqConsumer(this);
    }
}
