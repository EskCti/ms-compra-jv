package com.eskcti.mscompra.resources;

import com.eskcti.mscompra.models.Order;
import com.eskcti.mscompra.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.save(order));
    }
}
