package me.zhengjie.modules.product.service;

import me.zhengjie.modules.product.domain.Product;
import me.zhengjie.modules.product.service.dto.ProductDto;
import me.zhengjie.modules.product.service.dto.ProductQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @author hgw
*/
public interface ProductService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ProductQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ProductDto>
    */
    List<ProductDto> queryAll(ProductQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ProductDto
     */
    ProductDto findById(Long id);

    /**
    * 创建
    * @param resources /
    * @return ProductDto
    */
    ProductDto create(Product resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(Product resources);

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
    void download(List<ProductDto> all, HttpServletResponse response) throws IOException;
}