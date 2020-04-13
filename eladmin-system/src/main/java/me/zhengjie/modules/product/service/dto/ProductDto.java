package me.zhengjie.modules.product.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author hgw
*/
@Data
public class ProductDto implements Serializable {

    /** ID */
    private Long id;

    /** 商品名称 */
    private String name;

    /** 商品描述 */
    private String describe;

    /** 商品规格 */
    private String specification;

    /** 所属分类 */
    private Long categoryId;

    /** 库存 */
    private Long count;

    /** 原价 */
    private Double originalPrice;

    /** 活动价 */
    private Double activityPrice;

    /** 所属商家 */
    private Long merchantId;

    /** 状态 */
    private Boolean enabled;

    /** 创建日期 */
    private Timestamp createTime;
}