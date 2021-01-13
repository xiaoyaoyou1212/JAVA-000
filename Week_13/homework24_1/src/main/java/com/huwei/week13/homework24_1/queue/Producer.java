package com.huwei.week13.homework24_1.queue;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.*;

@Component
public class Producer {
    @Resource
    private JmsTemplate jmsTemplate;

    public void sendMessage(String queue, String message) {
        jmsTemplate.setDefaultDestinationName(queue);
        jmsTemplate.send(session -> {
            session.createQueue(queue);
            TextMessage text = session.createTextMessage(message);
            return text;
        });
    }
}
