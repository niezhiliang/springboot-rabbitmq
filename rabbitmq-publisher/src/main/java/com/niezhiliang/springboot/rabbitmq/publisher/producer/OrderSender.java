package com.niezhiliang.springboot.rabbitmq.publisher.producer;

import com.niezhiliang.springboot.rabbitmq.common.domain.BrokerMessageLog;
import com.niezhiliang.springboot.rabbitmq.common.domain.BrokerMessageLogExample;
import com.niezhiliang.springboot.rabbitmq.common.domain.Order;
import com.niezhiliang.springboot.rabbitmq.common.mapper.BrokerMessageLogMapper;
import com.niezhiliang.springboot.rabbitmq.publisher.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/1/24 上午9:56
 */
@Component
public class OrderSender {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;



    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {

        /**
         *
         * @param correlationData 唯一标识，有了这个唯一标识，我们就知道可以确认（失败）哪一条消息了
         * @param ack  是否投递成功
         * @param cause 失败原因
         */
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            String messageId = correlationData.getId();

            BrokerMessageLogExample brokerMessageLogExample =
                    new BrokerMessageLogExample();
            brokerMessageLogExample.createCriteria()
                    .andMessage_idEqualTo(messageId);

            BrokerMessageLog brokerMessageLog = null;
            try {
                brokerMessageLog =
                        brokerMessageLogMapper.selectByExample(brokerMessageLogExample).get(0);

            } catch (IndexOutOfBoundsException e) {
                logger.error("不存在messageId:{}的日志记录",messageId);
            }

            //返回成功，表示消息被正常投递
            if (ack) {
                brokerMessageLog.setStatus(Constants.ORDER_SEND_SUCCESS);
                brokerMessageLog.setUpdate_time(new Date());
                brokerMessageLogMapper.updateByPrimaryKeySelective(brokerMessageLog);

                logger.info("信息投递成功，messageId:{}",brokerMessageLog.getMessage_id());

            } else {
                logger.error("消费信息失败，messageId:{} 原因:{}",brokerMessageLog.getMessage_id(),cause);
            }
        }
    };


    /**
     * 信息投递的方法
     * @param order
     * @throws Exception
     */
    public void send(Order order) throws Exception{
        //设置投递回调
        rabbitTemplate.setConfirmCallback(confirmCallback);
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessage_id());

        rabbitTemplate.convertAndSend("order-exchange",
                "order.abcd",
                order,
                correlationData);
    }

}
