package com.nexwise.utils.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.C")
public class Receiver3 {
    @RabbitHandler
    public void receiverMessage(String msg) {
        System.out.println("Receiver3: " + msg);
    }
}
