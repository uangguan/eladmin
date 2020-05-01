package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderMainDo;

public class OrderPayedState implements OrderState {

    private OrderMainDo orderMainDo;

    public OrderPayedState(OrderMainDo orderMainDo) {
        this.orderMainDo = orderMainDo;
    }

    @Override
    public OrderStateEnum getName() {
        return OrderStateEnum.Payed;
    }

    @Override
    public void userCancleOrder() {
        orderMainDo.setCurrentState(new OrderUserCancledState(orderMainDo));
    }

    @Override
    public void sendOrder() {

    }
}
