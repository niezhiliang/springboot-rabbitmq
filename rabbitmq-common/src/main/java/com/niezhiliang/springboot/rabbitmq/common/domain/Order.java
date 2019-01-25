package com.niezhiliang.springboot.rabbitmq.common.domain;

import java.io.Serializable;

public class Order implements Serializable {

    private Integer id;

    private String name;

    private String message_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id == null ? null : message_id.trim();
    }
}