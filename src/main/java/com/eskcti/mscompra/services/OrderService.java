package com.eskcti.mscompra.services;

import com.eskcti.mscompra.models.Order;
import com.eskcti.mscompra.repositories.OrderRepository;
import com.eskcti.mscompra.services.rabbitmq.Producer;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final Producer producer;

    public OrderService(OrderRepository orderRepository, Producer producer) {
        this.orderRepository = orderRepository;
        this.producer = producer;
    }

    public Order save(Order order) {
        order = orderRepository.save(order);
        producer.sendOrder(order);
        return order;
    }
}
