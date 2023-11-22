package com.eskcti.mscompra.services.rabbitmq;

import com.eskcti.mscompra.models.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class Consumer {

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = {"${queue.name}"})
    public void consumer(@Payload String orderJson) {
        try {
            Order order = objectMapper.readValue(orderJson, Order.class);
            System.out.println("Objeto Order recebido: " + order);
        } catch (Exception e) {
            System.err.println("Erro ao converter JSON para objeto Order: " + e.getMessage());
        }
    }
}
