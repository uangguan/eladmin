package me.zhengjie.modules.product.service.dto;

import lombok.Data;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @author hgw
*/
@Data
public class OrderItemQueryCriteria{

    /** 精确 */
    @Query
    private String orderSn;
}