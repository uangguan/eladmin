package me.zhengjie.modules.order.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import me.zhengjie.modules.order.domain.status.OrderStateMachine;
import me.zhengjie.modules.system.domain.Dept;
import me.zhengjie.modules.system.domain.DictDetail;
import org.hibernate.annotations.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.List;

/**
* @author hgw
*/
@Entity
@Data
@Table(name="order_main")
public class OrderMain implements Serializable {

    /** 订单id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    /** 订单编号 */
    @Column(name = "order_sn",nullable = false)
    @NotBlank
    private String orderSn;

    /** 提交时间 */
    @Column(name = "create_time",nullable = false)
    @NotNull
    @CreationTimestamp
    private Timestamp createTime;

    /** 用户帐号 */
    @Column(name = "member_username",nullable = false)
    @NotBlank
    private String memberUsername;

    /** 订单总金额 */
    @Column(name = "total_amount",nullable = false)
    @NotNull
    private BigDecimal totalAmount;

    /** 应付金额 */
    @Column(name = "pay_amount",nullable = false)
    @NotNull
    private BigDecimal payAmount;

    /** 运费金额 */
    @Column(name = "freight_amount")
    private BigDecimal freightAmount;

    /** 支付方式 */
    @Column(name = "pay_type",nullable = false)
    @NotNull
    private Integer payType;

    /** 订单状态 */
    @Column(name = "status",nullable = false)
    @NotNull
    private Integer status;

    /** 物流公司 */
    @Column(name = "delivery_company")
    private String deliveryCompany;

    /** 物流单号 */
    @Column(name = "delivery_sn")
    private String deliverySn;

    /** 收货人姓名 */
    @Column(name = "receiver_name")
    private String receiverName;

    /** 收货人电话 */
    @Column(name = "receiver_phone")
    private String receiverPhone;

    /** 收货人邮编 */
    @Column(name = "receiver_post_code")
    private String receiverPostCode;

    /** 省份/直辖市 */
    @Column(name = "receiver_province")
    private String receiverProvince;

    /** 城市 */
    @Column(name = "receiver_city")
    private String receiverCity;

    /** 区 */
    @Column(name = "receiver_region")
    private String receiverRegion;

    /** 详细地址 */
    @Column(name = "receiver_detail_address")
    private String receiverDetailAddress;

    /** 订单备注 */
    @Column(name = "note")
    private String note;

    /** 确认收货状态 */
    @Column(name = "confirm_status",nullable = false)
    @NotNull
    private Integer confirmStatus;

    /** 删除状态 */
    @Column(name = "delete_status",nullable = false)
    @NotNull
    private Integer deleteStatus;

    /** 支付时间 */
    @Column(name = "payment_time")
    private Timestamp paymentTime;

    /** 发货时间 */
    @Column(name = "delivery_time")
    private Timestamp deliveryTime;

    /** 确认收货时间 */
    @Column(name = "receive_time")
    private Timestamp receiveTime;

    /** 修改时间 */
    @Column(name = "modify_time")
    @UpdateTimestamp
    private Timestamp modifyTime;

    /** 所属商家 */
    @OneToOne
    @JoinColumn(name = "merchant_id")
    private Dept dept;

    @OneToMany(mappedBy = "orderMain",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private List<OrderItem> orderItems;

    @Transient
    private OrderStateMachine orderStateMachine = new OrderStateMachine(this);

    public void copy(OrderMain source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }

    public boolean checkInventory() {
        return true;
    }
}