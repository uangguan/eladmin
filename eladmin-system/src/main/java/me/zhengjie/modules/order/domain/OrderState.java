package me.zhengjie.modules.order.domain;

public interface OrderState {

    OrderStateEnum getName();

    //订单库存校验
    public default void checkOrder() {

    }

    //订单创建
    public default void createOrder() {

    }

    //选择支付方式
    public default void selectPayType() {

    }

    //支付回调
    public default void payReturn() {

    }

    //超时/用户取消
    public default void cancleOrder() {

    }

    //发货
    public default void sendOrder() {

    }

    //确认收货
    public default void confirmOrder() {

    }

    //退货
    public default void returnOrder() {

    }
}
