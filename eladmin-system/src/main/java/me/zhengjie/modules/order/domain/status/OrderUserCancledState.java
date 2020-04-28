package me.zhengjie.modules.order.domain.status;

public class OrderUserCancledState implements OrderState {

    private OrderStateMachine stateMachine;

    public OrderUserCancledState(OrderStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.UseCancled;
    }

}
