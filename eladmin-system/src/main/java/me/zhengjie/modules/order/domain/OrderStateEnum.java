package me.zhengjie.modules.order.domain;

public enum OrderStateEnum {
    //已创建
    Created("0"),
    //未支付(待支付)
    UnPay("1"),
    //已支付(待发货）
    Payed("2"),
    //已发货(待收货）
    Sended("3"),
    //已完成
    Closed("4");

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
