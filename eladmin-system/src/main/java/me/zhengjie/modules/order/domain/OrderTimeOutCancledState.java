package me.zhengjie.modules.order.domain;

public class OrderTimeOutCancledState implements OrderState {

    private OrderStateMachine stateMachine;

    public OrderTimeOutCancledState(OrderStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.TimeOutCancled;
    }

}
