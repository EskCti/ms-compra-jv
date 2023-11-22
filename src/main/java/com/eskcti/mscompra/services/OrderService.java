package com.eskcti.mscompra.services;

import com.eskcti.mscompra.models.Order;
import com.eskcti.mscompra.repositories.OrderRepository;
import com.eskcti.mscompra.services.rabbitmq.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final Producer producer;

    public Order save(Order order) {
        order = orderRepository.save(order);
        producer.sendOrder(order.toString());
        return order;
    }
}
