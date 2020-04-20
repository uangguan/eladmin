package me.zhengjie.modules.order.service.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author hgw
*/
@Data
public class OrderItemDto implements Serializable {

    private Long id;

    /** 订单编号 */
    private String orderSn;

    /** 商品id */
    private Long productId;

    /** 商品名称 */
    private String productName;

    /** 销售价格 */
    private BigDecimal productPrice;

    /** 购买数量 */
    private Integer productQuantity;

    /** 商品分类id */
    private Long productCategoryId;

    /** 商品分类名称 */
    private String productCategoryName;

    /** 所属商家 */
    private Long merchantId;
}