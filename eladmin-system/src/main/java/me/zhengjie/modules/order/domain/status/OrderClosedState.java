package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderDo;

public class OrderClosedState implements OrderState {

    private OrderDo orderDo;

    public OrderClosedState(OrderDo stateMachine) {
        this.orderDo = orderDo;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.Closed;
    }

}
