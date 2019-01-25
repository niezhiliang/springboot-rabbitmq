package com.niezhiliang.springboot.rabbitmq.publisher.producer;


import com.niezhiliang.springboot.rabbitmq.common.domain.Order;
import com.niezhiliang.springboot.rabbitmq.publisher.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/1/24 上午10:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderSenderTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void setOrderSender() throws InterruptedException {
        Order order = new Order();
        order.setName(UUID.randomUUID().toString());
        order.setMessage_id(UUID.randomUUID().toString()+System.currentTimeMillis());
        orderService.createOrder(order);

        Thread.sleep(60000*5);
    }

}
