package com.eskcti.mscompra.services;

import com.eskcti.mscompra.models.Order;
import com.eskcti.mscompra.repositories.OrderRepository;
import com.eskcti.mscompra.services.rabbitmq.Producer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private Producer producer;

    private DataMock dataMock = new DataMock();

    @DisplayName("Save order with success")
    @Test
    void shouldSaveAnOrderWithSuccess() {
        var orderMock = dataMock.getOrder();

        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(orderMock);
        Mockito.doNothing().when(producer).sendOrder(Mockito.any(Order.class));

        var orderSaved = orderService.save(orderMock);

        assertEquals(orderMock.getZipCode(), orderSaved.getZipCode());
        assertTrue(orderSaved.getZipCode() != null);

    }
}
