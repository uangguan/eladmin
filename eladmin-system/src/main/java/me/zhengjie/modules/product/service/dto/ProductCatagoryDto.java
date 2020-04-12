package me.zhengjie.modules.product.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author hgw
* @date 2020-04-12
*/
@Data
public class ProductCatagoryDto implements Serializable {

    /** ID */
    private Long id;

    /** 分类名称 */
    private String name;

    /** 上级分类 */
    private Long pid;

    /** 状态 */
    private Boolean enabled;

    /** 创建日期 */
    private Timestamp createTime;

    /** 所属商家 */
    private Long merchantId;
}