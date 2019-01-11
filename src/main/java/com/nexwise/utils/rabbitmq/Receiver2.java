package com.nexwise.utils.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class Receiver2 {
    @RabbitHandler
    public void receiverMessage(String msg) {
        System.out.println("Receiver2: " + msg);
    }
}
