package com.huwei.xmq.demo;

import com.huwei.xmq.core.XmqBroker;
import com.huwei.xmq.core.XmqConsumer;
import com.huwei.xmq.core.XmqMessage;
import com.huwei.xmq.core.XmqProducer;

public class XmqDemo {

    public static void main(String[] args) {

        try {
            String topic = "xyy.test";
            XmqBroker broker = new XmqBroker();
            broker.createTopic(topic);

            XmqConsumer consumer = broker.createConsumer();
            consumer.subscribe(topic);
            final boolean[] flag = new boolean[1];
            flag[0] = true;
            new Thread(() -> {
                while (flag[0]) {
                    XmqMessage<Order> message = null;
                    try {
                        message = consumer.poll(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (null != message) {
                        System.out.println(message.getBody());
                    }
                }
                System.out.println("程序退出。");
            }).start();

            XmqProducer producer = broker.createProducer();
            for (int i = 0; i < 1000; i++) {
                Order order = new Order(1000L + i, System.currentTimeMillis(), "USD2CNY", 6.51d);
                producer.send(topic, new XmqMessage<>(null, order));
            }
            Thread.sleep(500);
            System.out.println("点击任何键，发送一条消息；点击q或e，退出程序。");
            while (true) {
                char c = (char) System.in.read();
                if (c > 20) {
                    System.out.println(c);
                    producer.send(topic, new XmqMessage<>(null, new Order(100000L + c, System.currentTimeMillis(), "USD2CNY", 6.52d)));
                }

                if (c == 'q' || c == 'e') {
                    break;
                }
            }

            flag[0] = false;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
