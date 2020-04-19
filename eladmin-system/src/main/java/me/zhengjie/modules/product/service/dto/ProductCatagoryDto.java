package me.zhengjie.modules.product.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import me.zhengjie.modules.system.service.dto.DeptDto;
import me.zhengjie.modules.system.service.dto.DeptSmallDto;

import java.sql.Timestamp;
import java.io.Serializable;
import java.util.List;

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

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ProductCatagoryDto> children;

    /** 所属商家 */
    private DeptSmallDto dept;

    public String getLabel() {
        return name;
    }

}