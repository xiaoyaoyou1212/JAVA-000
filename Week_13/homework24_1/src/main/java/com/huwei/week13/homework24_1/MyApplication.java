package com.huwei.week13.homework24_1;

import com.huwei.week13.homework24_1.queue.Producer;
import com.huwei.week13.homework24_1.topic.Publisher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import javax.annotation.Resource;

@EnableJms
@SpringBootApplication
public class MyApplication implements ApplicationRunner {

    @Resource
    private Producer producer;
    @Resource
    private Publisher publisher;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        producer.sendMessage("queue", "test queue message");
        for (int i = 0; i < 10; i++) {
            publisher.sendMessage("topic", "test topic message" + i);
        }
    }
}
