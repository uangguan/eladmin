package me.zhengjie.modules.product.service;

import me.zhengjie.modules.product.domain.ProductCatagory;
import me.zhengjie.modules.product.service.dto.ProductCatagoryDto;
import me.zhengjie.modules.product.service.dto.ProductCatagoryQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @author hgw
* @date 2020-04-11
*/
public interface ProductCatagoryService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ProductCatagoryQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ProductCatagoryDto>
    */
    List<ProductCatagoryDto> queryAll(ProductCatagoryQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ProductCatagoryDto
     */
    ProductCatagoryDto findById(Long id);

    /**
    * 创建
    * @param resources /
    * @return ProductCatagoryDto
    */
    ProductCatagoryDto create(ProductCatagory resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(ProductCatagory resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Long[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<ProductCatagoryDto> all, HttpServletResponse response) throws IOException;

    /**
     * 查询商品类别树
     * @param productCatagoryDtos
     * @return
     */
    Object buildTree(List<ProductCatagoryDto> productCatagoryDtos);
}