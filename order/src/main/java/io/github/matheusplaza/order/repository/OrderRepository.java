package io.github.matheusplaza.order.repository;

import io.github.matheusplaza.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
