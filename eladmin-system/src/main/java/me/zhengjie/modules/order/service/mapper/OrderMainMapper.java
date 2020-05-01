package me.zhengjie.modules.order.service.mapper;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.modules.order.repository.OrderMainPo;
import me.zhengjie.modules.order.service.dto.OrderMainDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author hgw
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMainMapper extends BaseMapper<OrderMainDto, OrderMainPo> {

}