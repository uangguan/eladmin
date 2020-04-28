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
        stateMachine.setCurrentState(new OrderUnPayState(stateMachine));
    }

    @Override
    public void userCancleOrder() {
        stateMachine.setCurrentState(new OrderUserCancledState(stateMachine));
    }

    @Override
    public void timeOutCancleOrder() {
        stateMachine.setCurrentState(new OrderTimeOutCancledState(stateMachine));
    }

    @Override
    public void arrivePayOrder() {
        stateMachine.setCurrentState(new OrderPayedState(stateMachine));
    }
}
