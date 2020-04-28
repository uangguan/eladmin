package me.zhengjie.modules.order.domain.status;

public enum OrderStateEnum {
    //初始化(订单未校验库存）
    Init("-1"),
    //已创建
    Created("0"),
    //未支付(待支付)
    UnPay("1"),
    //已支付(待发货）
    Payed("2"),
    //已发货(待收货）
    Sended("3"),
    //已完成
    Closed("4"),
    //超时取消
    TimeOutCancled("5"),
    //用户取消
    UseCancled("6");

    private String value;

    OrderStateEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static OrderStateEnum from(String value) {
        for (OrderStateEnum orderStateEnum : OrderStateEnum.values()) {
            if (orderStateEnum.value.equalsIgnoreCase(value)) {
                return orderStateEnum;
            }
        }

        return null;
    }
}
