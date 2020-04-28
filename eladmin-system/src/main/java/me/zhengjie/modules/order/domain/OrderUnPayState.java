package me.zhengjie.modules.order.domain;

public class OrderUnPayState implements OrderState {

    private OrderStateMachine stateMachine;

    public OrderUnPayState(OrderStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.UnPay;
    }

    @Override
    public void payReturn() {

    }

    @Override
    public void cancleOrder() {

    }
}
