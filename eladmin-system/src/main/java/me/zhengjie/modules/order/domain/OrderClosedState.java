package me.zhengjie.modules.order.domain;

public class OrderClosedState implements OrderState {

    private OrderStateMachine stateMachine;

    public OrderClosedState(OrderStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.Closed;
    }

    @Override
    public void createOrder() {
    }

    @Override
    public void selectPayType() {

    }

    @Override
    public void payReturn() {

    }

    @Override
    public void cancleOrder() {

    }

    @Override
    public void sendOrder() {

    }

    @Override
    public void confirmOrder() {

    }

    @Override
    public void returnOrder() {

    }
}
