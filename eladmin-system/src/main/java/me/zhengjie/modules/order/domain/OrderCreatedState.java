package me.zhengjie.modules.order.domain;

public class OrderCreatedState implements OrderState {

    private OrderStateMachine stateMachine;

    public OrderCreatedState(OrderStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.Created;
    }

    @Override
    public void selectPayType() {

    }

    @Override
    public void cancleOrder() {

    }
}
