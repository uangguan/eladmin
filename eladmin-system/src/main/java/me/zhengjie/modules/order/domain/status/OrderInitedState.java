package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderDo;

public class OrderInitedState implements OrderState {

    private OrderDo orderDo;

    public OrderInitedState(OrderDo orderDo) {
        this.orderDo = orderDo;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.Init;
    }

    @Override
    public void checkOrder() {
        boolean hasInventory = true;
        if (hasInventory) {
            orderDo.setCurrentState(new OrderCreatedState(orderDo));
        }
    }
}
