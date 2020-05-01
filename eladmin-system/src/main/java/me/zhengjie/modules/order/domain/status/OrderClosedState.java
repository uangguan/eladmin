package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderMainDo;

public class OrderClosedState implements OrderState {

    private OrderMainDo orderMainDo;

    public OrderClosedState(OrderMainDo stateMachine) {
        this.orderMainDo = orderMainDo;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.Closed;
    }

}
