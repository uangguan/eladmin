package me.zhengjie.modules.product.service.mapper;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.modules.product.domain.ProductCatagory;
import me.zhengjie.modules.product.service.dto.ProductCatagoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author hgw
* @date 2020-04-11
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCatagoryMapper extends BaseMapper<ProductCatagoryDto, ProductCatagory> {

}