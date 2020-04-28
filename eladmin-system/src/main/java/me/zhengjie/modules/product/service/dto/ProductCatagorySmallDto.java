package me.zhengjie.modules.product.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import me.zhengjie.modules.system.service.dto.DeptSmallDto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
* @author hgw
* @date 2020-04-12
*/
@Data
public class ProductCatagorySmallDto implements Serializable {

    /** ID */
    private Long id;

    /** 分类名称 */
    private String name;

}