package io.github.matheusplaza.order.service;

import io.github.matheusplaza.order.entity.Order;
import io.github.matheusplaza.order.entity.OrderEvent;
import io.github.matheusplaza.order.message.NotificationMessage;
import io.github.matheusplaza.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UpdateOrderService {

    private final OrderRepository orderRepository;
    private final OrderStateService orderStateService;
    private final NotificationProducerService notificationProducerService;
    public Order execute(String orderId, OrderEvent orderEvent) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));

        order.setStatus(orderStateService.processEvent(order.getStatus(), orderEvent));
        order.setUpdatedAt(LocalDateTime.now());

        notificationProducerService.sendMessage(NotificationMessage.builder()
                .orderId(order.getId())
                .message("Order status updated to " + order.getStatus())
                .orderEvent(orderEvent)
                .build());

        return orderRepository.save(order);
    }
}
