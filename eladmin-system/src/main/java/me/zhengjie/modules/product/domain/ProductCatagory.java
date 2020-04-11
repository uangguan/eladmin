package me.zhengjie.modules.product.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author hgw
* @date 2020-04-11
*/
@Entity
@Data
@Table(name="product_catagory")
public class ProductCatagory implements Serializable {

    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** 分类名称 */
    @Column(name = "name",nullable = false)
    @NotBlank
    private String name;

    /** 上级分类 */
    @Column(name = "pid",nullable = false)
    @NotNull
    private Long pid;

    /** 状态 */
    @Column(name = "enabled",nullable = false)
    @NotNull
    private Boolean enabled;

    /** 创建日期 */
    @Column(name = "create_time")
    private Timestamp createTime;

    public void copy(ProductCatagory source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}