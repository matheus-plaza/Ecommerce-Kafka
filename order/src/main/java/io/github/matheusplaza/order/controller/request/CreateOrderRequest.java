package io.github.matheusplaza.order.controller.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private String customerId;
    private String basketId;
    private BigDecimal amount;
    private BigDecimal shippingCost;
}
