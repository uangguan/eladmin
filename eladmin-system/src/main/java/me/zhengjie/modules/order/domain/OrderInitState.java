package me.zhengjie.modules.order.domain;

public class OrderInitState implements OrderState {

    private OrderStateMachine stateMachine;

    public OrderInitState(OrderStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.Init;
    }

    @Override
    public void checkOrder() {
        boolean hasInventory = stateMachine.getOrderMain().checkInventory();
        if (hasInventory) {
            stateMachine.setCurrentState(new OrderCreatedState(stateMachine));
        }
    }
}
