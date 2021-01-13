package com.huwei.week13.homework24_1.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class Consumer {
    @JmsListener(destination = "queue")
    public void receiveMessage(TextMessage textMessage) {
        System.out.println(textMessage.toString());
    }
}
