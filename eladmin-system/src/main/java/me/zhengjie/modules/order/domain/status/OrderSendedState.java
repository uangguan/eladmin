package me.zhengjie.modules.order.domain.status;

public class OrderSendedState implements OrderState {

    private OrderStateMachine stateMachine;

    public OrderSendedState(OrderStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.Sended;
    }

    @Override
    public void confirmOrder() {

    }


}
