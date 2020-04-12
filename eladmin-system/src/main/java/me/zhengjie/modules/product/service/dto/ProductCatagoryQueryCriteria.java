package me.zhengjie.modules.product.service.dto;

import lombok.Data;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @author hgw
* @date 2020-04-12
*/
@Data
public class ProductCatagoryQueryCriteria{

    /** 精确 */
    @Query
    private Long id;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    /** 精确 */
    @Query
    private Long pid;

    /** 精确 */
    @Query
    private Boolean enabled;

    /** 精确 */
    @Query
    private Long merchantId;
}