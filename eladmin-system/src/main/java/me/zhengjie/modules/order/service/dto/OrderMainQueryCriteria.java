package me.zhengjie.modules.order.service.dto;

import lombok.Data;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @author hgw
*/
@Data
public class OrderMainQueryCriteria{

    /** 精确 */
    @Query
    private String orderSn;

    /** 精确 */
    @Query
    private Long merchantId;
}