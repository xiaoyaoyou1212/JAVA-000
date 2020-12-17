package com.huwei.rpcfx.demo.provider;

import com.huwei.rpcfx.demo.api.Order;
import com.huwei.rpcfx.demo.api.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Order" + System.currentTimeMillis(), 9.9f);
    }
}
