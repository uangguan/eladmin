package me.zhengjie.modules.order.domain;

public interface OrderState {

    OrderStateEnum getName();

    //订单创建
    public void createOrder();

    //选择支付方式
    public void selectPayType();

    //支付回调
    public void payReturn();

    //超时/用户取消
    public void cancleOrder();

    //发货
    public void sendOrder();

    //确认收货
    public void confirmOrder();

    //退货
    public void returnOrder();
}
