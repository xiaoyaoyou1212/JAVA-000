package com.huwei.dubbo.demo.consumer;

import com.huwei.dubbo.demo.api.*;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class DubboClientApplication {

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private UserService userService;

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private OrderService orderService;

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(DubboClientApplication.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            User user = userService.findById(1);
            System.out.println("find user id=1 from server: " + user.getName());
            Order order = orderService.findOrderById(1992129);
            System.out.println(String.format("find order name=%s, amount=%f", order.getName(), order.getAmount()));
            Account account = accountService.findByUserId("1");
            System.out.println("find account:" + account.toString());
            accountService.payment("1", new BigDecimal("10"));
            Account account1 = accountService.findByUserId("1");
            System.out.println("find account:" + account1.toString());
        };
    }

}
