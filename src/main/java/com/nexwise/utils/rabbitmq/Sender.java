package com.nexwise.utils.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() throws JsonProcessingException {
        String json = "hello world 1";
        System.out.println("send1: " + json);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", json);
    }

}
