package io.github.matheusplaza.order.message;

import io.github.matheusplaza.order.entity.OrderEvent;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class NotificationMessage {
    private String orderId;
    private String message;
    private OrderEvent orderEvent;
}
