package me.zhengjie.modules.order.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;
import me.zhengjie.modules.order.repository.OrderMainPo;
import me.zhengjie.modules.system.domain.Dept;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author hgw
 */
@Data
public class OrderItemDo implements Serializable {

    private Long id;
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private Long productCategoryId;
    private String productCategoryName;
    private Dept dept;
    private OrderDo orderDo;

    public void copy(OrderItemDo source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }
}