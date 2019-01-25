package com.niezhiliang.springboot.rabbitmq.publisher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/1/24 上午9:48
 */
@SpringBootApplication
@MapperScan("com.niezhiliang.springboot.rabbitmq.common.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
