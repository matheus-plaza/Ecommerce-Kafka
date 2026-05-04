package io.github.matheusplaza.order.mapper;

import io.github.matheusplaza.order.controller.request.CreateOrderRequest;
import io.github.matheusplaza.order.controller.response.OrderResponse;
import io.github.matheusplaza.order.entity.Order;

public class OrderMapper {

    public static Order toOrder(CreateOrderRequest createOrderRequest) {
        return Order.builder()
                .customerId(createOrderRequest.getCustomerId())
                .basketId(createOrderRequest.getBasketId())
                .amount(createOrderRequest.getAmount())
                .shippingCost(createOrderRequest.getShippingCost())
                .build();
    }

    public static OrderResponse toOrderResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .basketId(order.getBasketId())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus())
                .paymentMethod(order.getPaymentMethod())
                .build();
    }

}
