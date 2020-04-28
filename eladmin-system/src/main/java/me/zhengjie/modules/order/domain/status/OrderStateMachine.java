package me.zhengjie.modules.order.domain.status;

import lombok.Data;
import me.zhengjie.modules.order.domain.OrderMain;

/***
 * 状态模式，观察者模式
 */
@Data
public class OrderStateMachine {

    private OrderState currentState;
    private OrderMain orderMain;

    public OrderStateMachine(OrderState currentState) {
        this.currentState = new OrderCreatedState(this);
    }

    public void checkOrder() {
        currentState.checkOrder();
    }

    public void createOrder() {
        currentState.createOrder();
    }

    public void selectPayType() {
        currentState.selectPayType();
    }

    public void payReturn() {
        currentState.payReturn();
    }

    public void userCancleOrder() {
        currentState.userCancleOrder();
    }

    public void timeOutCancleOrder() {
        currentState.timeOutCancleOrder();
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
