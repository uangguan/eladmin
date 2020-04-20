package me.zhengjie.modules.product.service.impl;

import me.zhengjie.modules.product.domain.OrderItem;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import me.zhengjie.modules.product.repository.OrderItemRepository;
import me.zhengjie.modules.product.service.OrderItemService;
import me.zhengjie.modules.product.service.dto.OrderItemDto;
import me.zhengjie.modules.product.service.dto.OrderItemQueryCriteria;
import me.zhengjie.modules.product.service.mapper.OrderItemMapper;
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
*/
@Service
//@CacheConfig(cacheNames = "orderItem")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    private final OrderItemMapper orderItemMapper;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    //@Cacheable
    public Map<String,Object> queryAll(OrderItemQueryCriteria criteria, Pageable pageable){
        Page<OrderItem> page = orderItemRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(orderItemMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<OrderItemDto> queryAll(OrderItemQueryCriteria criteria){
        return orderItemMapper.toDto(orderItemRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public OrderItemDto findById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseGet(OrderItem::new);
        ValidationUtil.isNull(orderItem.getId(),"OrderItem","id",id);
        return orderItemMapper.toDto(orderItem);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public OrderItemDto create(OrderItem resources) {
        return orderItemMapper.toDto(orderItemRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(OrderItem resources) {
        OrderItem orderItem = orderItemRepository.findById(resources.getId()).orElseGet(OrderItem::new);
        ValidationUtil.isNull( orderItem.getId(),"OrderItem","id",resources.getId());
        orderItem.copy(resources);
        orderItemRepository.save(orderItem);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            orderItemRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<OrderItemDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (OrderItemDto orderItem : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("订单编号", orderItem.getOrderSn());
            map.put("商品id", orderItem.getProductId());
            map.put("商品名称", orderItem.getProductName());
            map.put("销售价格", orderItem.getProductPrice());
            map.put("购买数量", orderItem.getProductQuantity());
            map.put("商品分类id", orderItem.getProductCategoryId());
            map.put("商品分类名称", orderItem.getProductCategoryName());
            map.put("所属商家", orderItem.getMerchantId());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}