package com.niezhiliang.springboot.rabbitmq.customer.consumer;

import com.niezhiliang.springboot.rabbitmq.common.domain.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/1/24 上午10:29
 */
@Component
public class OrderReceiver {


    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "order-queue",durable = "true"),
                    exchange = @Exchange(name = "order-exchange",
                    durable = "true",type = "topic"),
                    key="order.*"
            )
    )
    @RabbitHandler
    public void onOrderMessage(@Payload Order order, @Headers Map<String,Object> headers, Channel channel) throws Exception {
        System.out.println("----收到消息，开始消费-----");
        System.out.println("d订单id："+order.getId());
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        //ACK
        channel.basicAck(deliveryTag,false);
    }

}
