package com.niezhiliang.springboot.rabbitmq.publisher.controller;

import com.niezhiliang.springboot.rabbitmq.common.domain.Order;
import com.niezhiliang.springboot.rabbitmq.publisher.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/1/25 上午11:39
 */
@RestController
public class IndexController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "send")
    public String send() {
        //order对象必须实现序列化
        Order order = new Order();
        order.setName(UUID.randomUUID().toString());
        order.setMessage_id(UUID.randomUUID().toString()+System.currentTimeMillis());
        orderService.createOrder(order);
        return "success";
    }

}
