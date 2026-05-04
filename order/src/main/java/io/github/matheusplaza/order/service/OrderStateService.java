package io.github.matheusplaza.order.service;

import io.github.matheusplaza.order.entity.OrderEvent;
import io.github.matheusplaza.order.entity.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

@Service
public class OrderStateService {

    private final StateMachine<OrderStatus, OrderEvent> stateMachine;

    public OrderStateService(StateMachine<OrderStatus, OrderEvent> stateMachine) {
        this.stateMachine = stateMachine;
    }

    public OrderStatus processEvent(OrderStatus currentStatus, OrderEvent event) {
        stateMachine.stop();
        stateMachine.getStateMachineAccessor()
                .doWithAllRegions(access ->
                        access.resetStateMachine(new DefaultStateMachineContext<>(currentStatus, null, null, null)));
        stateMachine.start();

        boolean accepted = stateMachine.sendEvent(event);

        if (accepted) {
            return stateMachine.getState().getId();
        } else {
            throw new IllegalStateException("Transição inválida: " + event + " a partir de " + currentStatus);
        }
    }

}
