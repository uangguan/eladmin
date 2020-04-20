package me.zhengjie.modules.product.service.mapper;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.modules.product.domain.OrderItem;
import me.zhengjie.modules.product.service.dto.OrderItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author hgw
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemMapper extends BaseMapper<OrderItemDto, OrderItem> {

}