package com.niezhiliang.springboot.rabbitmq.common.service;

import com.niezhiliang.springboot.rabbitmq.common.domain.Order;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/1/25 上午9:24
 */
public interface OrderService {

    void createOrder(Order order);

}
