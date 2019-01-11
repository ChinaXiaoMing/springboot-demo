package com.nexwise.utils.rabbitmq;

import com.nexwise.utils.DateUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender2 {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String msg = "hello world 2";
        System.out.println("send2: " + msg);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg);
    }
}
