package io.github.matheusplaza.order.controller;

import io.github.matheusplaza.order.controller.request.CreateOrderRequest;
import io.github.matheusplaza.order.controller.request.UpdateOrderRequest;
import io.github.matheusplaza.order.controller.response.OrderResponse;
import io.github.matheusplaza.order.mapper.OrderMapper;
import io.github.matheusplaza.order.service.CreateOrderService;
import io.github.matheusplaza.order.service.UpdateOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CreateOrderService createOrderService;
    private final UpdateOrderService updateOrderService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return OrderMapper.toOrderResponse(
                createOrderService.execute(OrderMapper.toOrder(createOrderRequest))
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse updateOrder(@RequestBody UpdateOrderRequest updateOrderRequest) {
        return OrderMapper.toOrderResponse(
                updateOrderService.execute(
                        updateOrderRequest.getOrderId(),
                        updateOrderRequest.getOrderEvent())
        );
    }

}
