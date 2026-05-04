package io.github.matheusplaza.order.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.matheusplaza.order.entity.OrderStatus;
import io.github.matheusplaza.order.entity.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private String id;
    private String customerId;
    private String basketId;
    private BigDecimal totalAmount;
    private OrderStatus status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PaymentMethod paymentMethod;
}
