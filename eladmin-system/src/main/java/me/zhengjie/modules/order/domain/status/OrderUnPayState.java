package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderDo;

public class OrderUnPayState implements OrderState {

    private OrderDo orderDo;

    public OrderUnPayState(OrderDo orderDo) {
        this.orderDo = orderDo;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.UnPay;
    }

    @Override
    public void payReturn() {

    }

    @Override
    public void userCancleOrder() {
        orderDo.setCurrentState(new OrderUserCancledState(orderDo));
    }

    @Override
    public void timeOutCancleOrder() {
        orderDo.setCurrentState(new OrderTimeOutCancledState(orderDo));
    }
}
