package com.niezhiliang.springboot.rabbitmq.publisher.task;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.springboot.rabbitmq.common.domain.BrokerMessageLogExample;
import com.niezhiliang.springboot.rabbitmq.common.domain.Order;
import com.niezhiliang.springboot.rabbitmq.common.mapper.BrokerMessageLogMapper;
import com.niezhiliang.springboot.rabbitmq.publisher.constants.Constants;
import com.niezhiliang.springboot.rabbitmq.publisher.producer.OrderSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/1/25 上午9:26
 */
@Component
public class TrySendTask {

    @Autowired
    private OrderSender orderSender;

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    /**
     * 系统启动后5秒开启定时任务 10秒执行一次
     */
    @Scheduled(initialDelay = 5000, fixedDelay = 10000)
    public void rabbitmqReSend() {

        BrokerMessageLogExample brokerMessageLogExample =
                new BrokerMessageLogExample();
        brokerMessageLogExample.createCriteria()
                .andStatusEqualTo(Constants.ORDER_SENDING)
                .andNext_retryLessThan(new Date());

        /**
         *
         * 查询出下一次执行时间小于当前时间的日志记录并且状态为投递中，
         * 遍历结果集，判断重试次数是或大于3次，如果大于，将日志设置为投递失败，
         * 如果小于 则尝试重新投递，并改变数据库中日志的尝试次数
         *
         */
        brokerMessageLogMapper.selectByExample(brokerMessageLogExample)
                .forEach(brokerMessageLog -> {
                    if (brokerMessageLog.getTry_count() >= 3) {
                        brokerMessageLog.setStatus(Constants.ORDER_SEND_FAILURE);
                        brokerMessageLog.setUpdate_time(new Date());
                        brokerMessageLogMapper.updateByPrimaryKeySelective(brokerMessageLog);

                    } else {
                        brokerMessageLog.setTry_count(brokerMessageLog.getTry_count() + 1);
                        brokerMessageLog.setUpdate_time(new Date());
                        brokerMessageLogMapper.updateByPrimaryKeySelective(brokerMessageLog);

                        try {
                            //重新投递信息
                            orderSender.send(JSONObject.parseObject(brokerMessageLog.getMessage(),Order.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                });

    }

}
