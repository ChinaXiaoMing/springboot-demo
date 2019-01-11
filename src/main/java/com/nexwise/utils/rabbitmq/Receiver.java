package com.nexwise.utils.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.A")
public class Receiver {

    @RabbitHandler
    public void receiverMessage(String msg) {
        System.out.println("Receiver1: " + msg);
    }

}
