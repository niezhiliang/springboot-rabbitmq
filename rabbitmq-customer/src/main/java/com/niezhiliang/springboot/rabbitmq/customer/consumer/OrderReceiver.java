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
            bindings = @QueueBinding(                    //数据是否持久化
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

        /**
         *  取值为 false 时，表示通知 RabbitMQ 当前消息被确认
         *  如果为 true，则额外将比第一个参数指定的 delivery tag 小的消息一并确认
         */
        channel.basicAck(deliveryTag,false);
        System.out.println("--------消费完成--------");
    }

}
