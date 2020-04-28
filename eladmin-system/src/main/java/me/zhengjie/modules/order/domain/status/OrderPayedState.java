package me.zhengjie.modules.order.domain.status;

public class OrderPayedState implements OrderState {

    private OrderStateMachine stateMachine;

    public OrderPayedState(OrderStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.Payed;
    }

    @Override
    public void userCancleOrder() {
        stateMachine.setCurrentState(new OrderUserCancledState(stateMachine));
    }

    @Override
    public void sendOrder() {

    }
}
