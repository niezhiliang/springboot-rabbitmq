package com.niezhiliang.springboot.rabbitmq.common.mapper;

import com.niezhiliang.springboot.rabbitmq.common.domain.BrokerMessageLog;
import com.niezhiliang.springboot.rabbitmq.common.domain.BrokerMessageLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrokerMessageLogMapper {
    long countByExample(BrokerMessageLogExample example);

    int deleteByExample(BrokerMessageLogExample example);

    int deleteByPrimaryKey(String message_id);

    int insert(BrokerMessageLog record);

    int insertSelective(BrokerMessageLog record);

    List<BrokerMessageLog> selectByExample(BrokerMessageLogExample example);

    BrokerMessageLog selectByPrimaryKey(String message_id);

    int updateByExampleSelective(@Param("record") BrokerMessageLog record, @Param("example") BrokerMessageLogExample example);

    int updateByExample(@Param("record") BrokerMessageLog record, @Param("example") BrokerMessageLogExample example);

    int updateByPrimaryKeySelective(BrokerMessageLog record);

    int updateByPrimaryKey(BrokerMessageLog record);
}