package me.zhengjie.modules.order.domain.status;

import me.zhengjie.modules.order.domain.OrderMainDo;

public class OrderInitedState implements OrderState {

    private OrderMainDo orderMainDo;

    public OrderInitedState(OrderMainDo orderMainDo) {
        this.orderMainDo = orderMainDo;
    }

    @Override
    public OrderStateEnum getName() {
            return OrderStateEnum.Init;
    }

    @Override
    public void checkOrder() {
        boolean hasInventory = true;
        if (hasInventory) {
            orderMainDo.setCurrentState(new OrderCreatedState(orderMainDo));
        }
    }
}
