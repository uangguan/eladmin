package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderMainDo;

public class OrderUnPayState implements OrderState {

    private OrderMainDo orderMainDo;

    public OrderUnPayState(OrderMainDo orderMainDo) {
        this.orderMainDo = orderMainDo;
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
        orderMainDo.setCurrentState(new OrderUserCancledState(orderMainDo));
    }

    @Override
    public void timeOutCancleOrder() {
        orderMainDo.setCurrentState(new OrderTimeOutCancledState(orderMainDo));
    }
}
