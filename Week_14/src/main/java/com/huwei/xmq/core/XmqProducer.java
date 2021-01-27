package com.huwei.xmq.core;

public class XmqProducer {
    private XmqBroker broker;

    public XmqProducer(XmqBroker broker) {
        this.broker = broker;
    }

    public boolean send(String topic, XmqMessage message) {
        Xmq xmq = this.broker.findXmq(topic);
        if (null == xmq) {
            throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        }
        return xmq.send(message);
    }
}
