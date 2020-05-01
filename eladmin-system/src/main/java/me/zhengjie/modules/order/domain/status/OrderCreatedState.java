package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderMainDo;

public class OrderCreatedState implements OrderState {

    private OrderMainDo orderMainDo;

    public OrderCreatedState(OrderMainDo orderMainDo) {
        this.orderMainDo = orderMainDo;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.Created;
    }

    @Override
    public void selectPayType() {
        orderMainDo.setCurrentState(new OrderUnPayState(orderMainDo));
    }

    @Override
    public void userCancleOrder() {
        orderMainDo.setCurrentState(new OrderUserCancledState(orderMainDo));
    }

    @Override
    public void timeOutCancleOrder() {
        orderMainDo.setCurrentState(new OrderTimeOutCancledState(orderMainDo));
    }

    @Override
    public void arrivePayOrder() {
        orderMainDo.setCurrentState(new OrderPayedState(orderMainDo));
    }
}
