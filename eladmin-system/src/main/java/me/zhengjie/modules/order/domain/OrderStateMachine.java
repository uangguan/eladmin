package me.zhengjie.modules.order.domain;

public class OrderStateMachine {

    private OrderState currentState;

    public void createOrder() {
        currentState.createOrder();
    }

    public void selectPayType() {
        currentState.selectPayType();
    }

    public void payReturn() {
        currentState.payReturn();
    }

    public void cancleOrder() {
        currentState.cancleOrder();
    }

    public void sendOrder() {
        currentState.sendOrder();
    }

    public void confirmOrder() {
        currentState.confirmOrder();
    }

    public void returnOrder() {
        currentState.returnOrder();
    }
}
