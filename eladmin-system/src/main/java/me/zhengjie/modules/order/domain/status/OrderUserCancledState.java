package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderDo;

public class OrderUserCancledState implements OrderState {

    private OrderDo orderDo;

    public OrderUserCancledState(OrderDo orderDo) {
        this.orderDo = orderDo;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.UseCancled;
    }

}
