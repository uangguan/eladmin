package me.zhengjie.modules.product.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author hgw
*/
@Entity
@Data
@Table(name="order_item")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** 订单编号 */
    @Column(name = "order_sn",nullable = false)
    @NotBlank
    private String orderSn;

    /** 商品id */
    @Column(name = "product_id",nullable = false)
    @NotNull
    private Long productId;

    /** 商品名称 */
    @Column(name = "product_name",nullable = false)
    @NotBlank
    private String productName;

    /** 销售价格 */
    @Column(name = "product_price",nullable = false)
    @NotNull
    private BigDecimal productPrice;

    /** 购买数量 */
    @Column(name = "product_quantity",nullable = false)
    @NotNull
    private Integer productQuantity;

    /** 商品分类id */
    @Column(name = "product_category_id",nullable = false)
    @NotNull
    private Long productCategoryId;

    /** 商品分类名称 */
    @Column(name = "product_category_name",nullable = false)
    @NotBlank
    private String productCategoryName;

    /** 所属商家 */
    @Column(name = "merchant_id",nullable = false)
    @NotNull
    private Long merchantId;

    public void copy(OrderItem source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}