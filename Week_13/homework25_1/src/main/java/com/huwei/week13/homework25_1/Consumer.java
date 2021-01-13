package com.huwei.week13.homework25_1;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(id = "consumer-id", topics = "topic")
    public void receiveMessage(String message) {
        System.out.println(message);
    }
}
