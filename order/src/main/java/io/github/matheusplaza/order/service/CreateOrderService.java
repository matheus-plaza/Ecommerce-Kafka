package io.github.matheusplaza.order.service;

import io.github.matheusplaza.order.entity.Order;
import io.github.matheusplaza.order.entity.OrderStatus;
import io.github.matheusplaza.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateOrderService {
    private final OrderRepository orderRepository;

    public Order execute(Order order) {

        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        //TODO: enviar msg pro kafka

        return orderRepository.save(order);
    }
}
