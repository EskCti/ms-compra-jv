package com.eskcti.mscompra.services.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = {"${queue.name}"})
    public void consumer(@Payload String order) {
        System.out.println("Mensagem recebida: " + order);
    }
}
