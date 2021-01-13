package com.huwei.week13.homework24_1.topic;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.TextMessage;

@Component
public class Publisher {
    @Resource
    private JmsTemplate jmsTemplate;

    public void sendMessage(String topic, String message) {
        jmsTemplate.setDefaultDestinationName(topic);
        jmsTemplate.send(session -> {
            session.createTopic(topic);
            TextMessage text = session.createTextMessage(message);
            return text;
        });
    }
}
