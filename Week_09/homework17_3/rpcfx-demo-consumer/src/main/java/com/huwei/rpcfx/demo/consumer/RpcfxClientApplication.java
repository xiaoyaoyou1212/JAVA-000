package com.huwei.rpcfx.demo.consumer;

import com.huwei.rpcfx.client.Rpcfx;
import com.huwei.rpcfx.demo.api.Order;
import com.huwei.rpcfx.demo.api.OrderService;
import com.huwei.rpcfx.demo.api.User;
import com.huwei.rpcfx.demo.api.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpcfxClientApplication {

    // 二方库
    // 三方库 lib
    // nexus, userserivce -> userdao -> user
    //

    public static void main(String[] args) {

        // UserService service = new xxx();
        // service.findById

        UserService userService = Rpcfx.create(UserService.class, "http://localhost:8080/");
        User user = userService.findById(1);
        System.out.println("find user id=1 from server: " + user.getName());

        OrderService orderService = Rpcfx.create(OrderService.class, "http://localhost:8080/");
        Order order = orderService.findOrderById(1992129);
        System.out.println(String.format("find order name=%s, amount=%f", order.getName(), order.getAmount()));

        // 新加一个OrderService

//		SpringApplication.run(RpcfxClientApplication.class, args);
    }

}
