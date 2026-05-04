package io.github.matheusplaza.order.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document(collation = "orders")
public class Order {

    @Id
    private String id;
    private String customerId;
    private String basketId;
    private BigDecimal amount;
    private BigDecimal shippingCost;
    private OrderStatus status;
    private PaymentMethod paymentMethod;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BigDecimal getTotalAmount() {
        return amount.add(shippingCost);
    }
}
