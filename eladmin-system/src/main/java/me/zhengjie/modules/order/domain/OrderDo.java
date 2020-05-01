package me.zhengjie.modules.order.domain;

import lombok.Data;
import me.zhengjie.modules.order.domain.status.OrderInitedState;
import me.zhengjie.modules.order.domain.status.OrderState;
import me.zhengjie.modules.system.domain.Dept;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/***
 * 状态模式嵌入领域模型Do，领域模型Do和持久化模型Po分离
 */
@Data
public class OrderDo {

    private OrderState currentState;

    public OrderDo() {
        this.currentState = new OrderInitedState(this);
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

    public void setCurrentState(OrderState currentState) {
        this.currentState = currentState;
    }

    private Long id;
    private String orderSn;
    private Timestamp createTime;
    private String memberUsername;
    private BigDecimal totalAmount;
    private BigDecimal payAmount;
    private BigDecimal freightAmount;
    private Integer payType;
    private Integer status;
    private String deliveryCompany;
    private String deliverySn;
    private String receiverName;
    private String receiverPhone;
    private String receiverPostCode;
    private String receiverProvince;
    private String receiverCity;
    private String receiverRegion;
    private String receiverDetailAddress;
    private String note;
    private Integer confirmStatus;
    private Integer deleteStatus;
    private Timestamp paymentTime;
    private Timestamp deliveryTime;
    private Timestamp receiveTime;
    private Timestamp modifyTime;
    private Dept dept;
    private List<OrderItemDo> orderItemDos;
}
