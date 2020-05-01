package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderMainDo;

public class OrderSendedState implements OrderState {

    private OrderMainDo orderMainDo;

    public OrderSendedState(OrderMainDo orderMainDo) {
        this.orderMainDo = orderMainDo;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.Sended;
    }

    @Override
    public void confirmOrder() {

    }


}
