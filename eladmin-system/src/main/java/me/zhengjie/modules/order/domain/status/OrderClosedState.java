package me.zhengjie.modules.order.domain.status;

public class OrderClosedState implements OrderState {

    private OrderStateMachine stateMachine;

    public OrderClosedState(OrderStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.Closed;
    }

}
