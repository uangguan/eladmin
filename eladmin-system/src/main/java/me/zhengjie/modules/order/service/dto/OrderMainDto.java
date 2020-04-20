package me.zhengjie.modules.order.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author hgw
*/
@Data
public class OrderMainDto implements Serializable {

    /** 订单编号 */
    private String orderSn;

    /** 提交时间 */
    private Timestamp createTime;

    /** 用户帐号 */
    private String memberUsername;

    /** 订单总金额 */
    private BigDecimal totalAmount;

    /** 应付金额 */
    private BigDecimal payAmount;

    /** 运费金额 */
    private BigDecimal freightAmount;

    /** 支付方式 */
    private Integer payType;

    /** 订单状态 */
    private Integer status;

    /** 物流公司 */
    private String deliveryCompany;

    /** 物流单号 */
    private String deliverySn;

    /** 收货人姓名 */
    private String receiverName;

    /** 收货人电话 */
    private String receiverPhone;

    /** 收货人邮编 */
    private String receiverPostCode;

    /** 省份/直辖市 */
    private String receiverProvince;

    /** 城市 */
    private String receiverCity;

    /** 区 */
    private String receiverRegion;

    /** 详细地址 */
    private String receiverDetailAddress;

    /** 订单备注 */
    private String note;

    /** 确认收货状态 */
    private Integer confirmStatus;

    /** 删除状态 */
    private Integer deleteStatus;

    /** 支付时间 */
    private Timestamp paymentTime;

    /** 发货时间 */
    private Timestamp deliveryTime;

    /** 确认收货时间 */
    private Timestamp receiveTime;

    /** 修改时间 */
    private Timestamp modifyTime;

    /** 所属商家 */
    private Long merchantId;

    /** 订单id */
    private Long id;
}