package com.nexwise.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Descript Rabbitmq配置类
 * @Author fuyuanming
 * @Date 2019-01-10 10:14:22
 * @Version 1.0
 */
//@Configuration
public class RabbitmqConfig {

//    @Bean
//    public Queue helloQueue() {
//        return new Queue("fanout.A");
//    }
//
//    @Bean
//    public Queue topicMessage() {
//        return new Queue("fanout.B");
//    }
//
//    @Bean
//    public Queue topicMessages() {
//        return new Queue("fanout.C");
//    }
//
//    @Bean
//    FanoutExchange fanoutExchange() {
//        return new FanoutExchange("fanoutExchange");
//    }
//
//    @Bean
//    Binding bindingFanoutExchangeHello(Queue helloQueue, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(helloQueue).to(fanoutExchange);
//    }
//
//    @Bean
//    Binding bindingFanoutExchangeMessage(Queue topicMessage, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(topicMessage).to(fanoutExchange);
//    }
//
//    @Bean
//    Binding bindingFanoutExchangeMessages(Queue topicMessages, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(topicMessages).to(fanoutExchange);
//    }

}
