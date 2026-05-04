package io.github.matheusplaza.order.controller.request;

import io.github.matheusplaza.order.entity.OrderEvent;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderRequest {
    private String orderId;
    private OrderEvent orderEvent;
}
