package io.github.matheusplaza.order.service;

import io.github.matheusplaza.order.entity.Order;
import io.github.matheusplaza.order.entity.OrderEvent;
import io.github.matheusplaza.order.entity.OrderStatus;
import io.github.matheusplaza.order.message.NotificationMessage;
import io.github.matheusplaza.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateOrderService {
    private final OrderRepository orderRepository;
    private final NotificationProducerService notificationProducerService;

    public Order execute(Order order) {

        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        notificationProducerService.sendMessage(NotificationMessage
                .builder()
                .orderId(order.getId())
                .message("New order created")
                .orderEvent(OrderEvent.CREATE)
                .build());

        return orderRepository.save(order);
    }
}
