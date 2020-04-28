package me.zhengjie.modules.order.service.dto;

import lombok.Data;
import java.util.List;
import java.util.Set;

import me.zhengjie.annotation.Query;

/**
* @author hgw
*/
@Data
public class OrderMainQueryCriteria{

    /** 精确 */
    @Query
    private String orderSn;

    @Query(propName = "id", type = Query.Type.IN, joinName = "dept")
    private Set<Long> deptIds;

    private Long deptId;
}