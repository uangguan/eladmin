package me.zhengjie.modules.order.service.mapper;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.modules.order.repository.OrderItemPo;
import me.zhengjie.modules.order.service.dto.OrderItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author hgw
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemMapper extends BaseMapper<OrderItemDto, OrderItemPo> {

}