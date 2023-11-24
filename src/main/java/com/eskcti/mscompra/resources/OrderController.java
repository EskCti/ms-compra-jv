package com.eskcti.mscompra.resources;

import com.eskcti.mscompra.models.Order;
import com.eskcti.mscompra.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor(onConstructor = @__(@Autowired))

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<Order> save(@RequestBody @Valid Order order) {
        return ResponseEntity.ok(orderService.save(order));
    }
}
