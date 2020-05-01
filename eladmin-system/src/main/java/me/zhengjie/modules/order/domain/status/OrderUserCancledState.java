package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderMainDo;

public class OrderUserCancledState implements OrderState {

    private OrderMainDo orderMainDo;

    public OrderUserCancledState(OrderMainDo orderMainDo) {
        this.orderMainDo = orderMainDo;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.UseCancled;
    }

}
