package io.github.matheusplaza.notification.message;

import io.github.matheusplaza.notification.entity.OrderEvent;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class NotificationMessage {
    private String orderId;
    private String message;
    private OrderEvent orderEvent;
}
