package me.zhengjie.modules.product.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author hgw
*/
@Entity
@Data
@Table(name="product")
public class Product implements Serializable {

    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** 商品名称 */
    @Column(name = "name",nullable = false)
    @NotBlank
    private String name;

    /** 商品描述 */
    @Column(name = "describe")
    private String describe;

    /** 商品规格 */
    @Column(name = "specification")
    private String specification;

    /** 所属分类 */
    @Column(name = "category_id",nullable = false)
    @NotNull
    private Long categoryId;

    /** 库存 */
    @Column(name = "count",nullable = false)
    @NotNull
    private Long count;

    /** 原价 */
    @Column(name = "original_price",nullable = false)
    @NotNull
    private Double originalPrice;

    /** 活动价 */
    @Column(name = "activity_price",nullable = false)
    @NotNull
    private Double activityPrice;

    /** 所属商家 */
    @Column(name = "merchant_id",nullable = false)
    @NotNull
    private Long merchantId;

    /** 状态 */
    @Column(name = "enabled",nullable = false)
    @NotNull
    private Boolean enabled;

    /** 创建日期 */
    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    public void copy(Product source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}