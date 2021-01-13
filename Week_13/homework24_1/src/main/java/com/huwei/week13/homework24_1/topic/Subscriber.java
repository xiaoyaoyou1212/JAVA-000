package com.huwei.week13.homework24_1.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class Subscriber {
    @JmsListener(destination = "topic")
    public void receiveMessage(TextMessage textMessage) {
        System.out.println(textMessage.toString());
    }
}
