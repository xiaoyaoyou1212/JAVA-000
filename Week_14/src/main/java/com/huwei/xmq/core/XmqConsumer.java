package com.huwei.xmq.core;

public class XmqConsumer<T> {
    private final XmqBroker broker;

    private Xmq xmq;

    public XmqConsumer(XmqBroker broker) {
        this.broker = broker;
    }

    public void subscribe(String topic) {
        this.xmq = this.broker.findXmq(topic);
        if (null == xmq) {
            throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        }
    }

    public XmqMessage<T> poll(long timeout) throws InterruptedException {
        return xmq.poll(timeout);
    }

}
