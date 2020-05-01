package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderDo;

public class OrderPayedState implements OrderState {

    private OrderDo orderDo;

    public OrderPayedState(OrderDo orderDo) {
        this.orderDo = orderDo;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.Payed;
    }

    @Override
    public void userCancleOrder() {
        orderDo.setCurrentState(new OrderUserCancledState(orderDo));
    }

    @Override
    public void sendOrder() {

    }
}
