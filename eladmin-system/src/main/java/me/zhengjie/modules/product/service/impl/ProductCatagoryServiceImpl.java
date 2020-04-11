package me.zhengjie.modules.product.service.impl;

import me.zhengjie.modules.product.domain.ProductCatagory;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import me.zhengjie.modules.product.repository.ProductCatagoryRepository;
import me.zhengjie.modules.product.service.ProductCatagoryService;
import me.zhengjie.modules.product.service.dto.ProductCatagoryDto;
import me.zhengjie.modules.product.service.dto.ProductCatagoryQueryCriteria;
import me.zhengjie.modules.product.service.mapper.ProductCatagoryMapper;
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
//@CacheConfig(cacheNames = "productCatagory")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProductCatagoryServiceImpl implements ProductCatagoryService {

    private final ProductCatagoryRepository productCatagoryRepository;

    private final ProductCatagoryMapper productCatagoryMapper;

    public ProductCatagoryServiceImpl(ProductCatagoryRepository productCatagoryRepository, ProductCatagoryMapper productCatagoryMapper) {
        this.productCatagoryRepository = productCatagoryRepository;
        this.productCatagoryMapper = productCatagoryMapper;
    }

    @Override
    //@Cacheable
    public Map<String,Object> queryAll(ProductCatagoryQueryCriteria criteria, Pageable pageable){
        Page<ProductCatagory> page = productCatagoryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(productCatagoryMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<ProductCatagoryDto> queryAll(ProductCatagoryQueryCriteria criteria){
        return productCatagoryMapper.toDto(productCatagoryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public ProductCatagoryDto findById(Long id) {
        ProductCatagory productCatagory = productCatagoryRepository.findById(id).orElseGet(ProductCatagory::new);
        ValidationUtil.isNull(productCatagory.getId(),"ProductCatagory","id",id);
        return productCatagoryMapper.toDto(productCatagory);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public ProductCatagoryDto create(ProductCatagory resources) {
        return productCatagoryMapper.toDto(productCatagoryRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(ProductCatagory resources) {
        ProductCatagory productCatagory = productCatagoryRepository.findById(resources.getId()).orElseGet(ProductCatagory::new);
        ValidationUtil.isNull( productCatagory.getId(),"ProductCatagory","id",resources.getId());
        productCatagory.copy(resources);
        productCatagoryRepository.save(productCatagory);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            productCatagoryRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<ProductCatagoryDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ProductCatagoryDto productCatagory : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("分类名称", productCatagory.getName());
            map.put("上级分类", productCatagory.getPid());
            map.put("状态", productCatagory.getEnabled());
            map.put("创建日期", productCatagory.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}