package me.zhengjie.modules.product.service.impl;

import me.zhengjie.modules.product.domain.Product;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import me.zhengjie.modules.product.repository.ProductRepository;
import me.zhengjie.modules.product.service.ProductService;
import me.zhengjie.modules.product.service.dto.ProductDto;
import me.zhengjie.modules.product.service.dto.ProductQueryCriteria;
import me.zhengjie.modules.product.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
* @author hgw
* @date 2020-04-11
*/
@Service
//@CacheConfig(cacheNames = "product")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    //@Cacheable
    public Map<String,Object> queryAll(ProductQueryCriteria criteria, Pageable pageable){
        Page<Product> page = productRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(productMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<ProductDto> queryAll(ProductQueryCriteria criteria){
        return productMapper.toDto(productRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id).orElseGet(Product::new);
        ValidationUtil.isNull(product.getId(),"Product","id",id);
        return productMapper.toDto(product);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public ProductDto create(Product resources) {
        return productMapper.toDto(productRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Product resources) {
        Product product = productRepository.findById(resources.getId()).orElseGet(Product::new);
        ValidationUtil.isNull( product.getId(),"Product","id",resources.getId());
        product.copy(resources);
        productRepository.save(product);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            productRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<ProductDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ProductDto product : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("商品名称", product.getName());
            map.put("商品描述", product.getDescribe());
            map.put("商品规格", product.getSpecification());
            map.put("所属分类", product.getCategoryId());
            map.put("库存", product.getCount());
            map.put("原价", product.getOriginalPrice());
            map.put("活动价", product.getActivityPrice());
            map.put("所属商家", product.getMerchantId());
            map.put("状态", product.getEnabled());
            map.put("创建日期", product.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}