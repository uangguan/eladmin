package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderDo;

public class OrderCreatedState implements OrderState {

    private OrderDo orderDo;

    public OrderCreatedState(OrderDo orderDo) {
        this.orderDo = orderDo;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.Created;
    }

    @Override
    public void selectPayType() {
        orderDo.setCurrentState(new OrderUnPayState(orderDo));
    }

    @Override
    public void userCancleOrder() {
        orderDo.setCurrentState(new OrderUserCancledState(orderDo));
    }

    @Override
    public void timeOutCancleOrder() {
        orderDo.setCurrentState(new OrderTimeOutCancledState(orderDo));
    }

    @Override
    public void arrivePayOrder() {
        orderDo.setCurrentState(new OrderPayedState(orderDo));
    }
}
