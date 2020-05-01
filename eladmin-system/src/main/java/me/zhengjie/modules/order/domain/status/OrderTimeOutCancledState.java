package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderMainDo;

public class OrderTimeOutCancledState implements OrderState {

    private OrderMainDo orderMainDo;

    public OrderTimeOutCancledState(OrderMainDo orderMainDo) {
        this.orderMainDo = orderMainDo;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.TimeOutCancled;
    }

}
