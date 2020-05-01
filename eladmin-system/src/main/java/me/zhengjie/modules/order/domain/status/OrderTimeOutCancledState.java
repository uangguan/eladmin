package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderDo;

public class OrderTimeOutCancledState implements OrderState {

    private OrderDo orderDo;

    public OrderTimeOutCancledState(OrderDo orderDo) {
        this.orderDo = orderDo;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.TimeOutCancled;
    }

}
