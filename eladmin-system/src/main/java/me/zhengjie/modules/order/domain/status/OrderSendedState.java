package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderDo;

public class OrderSendedState implements OrderState {

    private OrderDo orderDo;

    public OrderSendedState(OrderDo orderDo) {
        this.orderDo = orderDo;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.Sended;
    }

    @Override
    public void confirmOrder() {

    }


}
