package me.zhengjie.modules.order.service.impl;

import me.zhengjie.modules.order.domain.OrderMain;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import me.zhengjie.modules.order.repository.OrderMainRepository;
import me.zhengjie.modules.order.service.OrderMainService;
import me.zhengjie.modules.order.service.dto.OrderMainDto;
import me.zhengjie.modules.order.service.dto.OrderMainQueryCriteria;
import me.zhengjie.modules.order.service.mapper.OrderMainMapper;
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
//@CacheConfig(cacheNames = "orderMain")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderMainServiceImpl implements OrderMainService {

    private final OrderMainRepository orderMainRepository;

    private final OrderMainMapper orderMainMapper;

    public OrderMainServiceImpl(OrderMainRepository orderMainRepository, OrderMainMapper orderMainMapper) {
        this.orderMainRepository = orderMainRepository;
        this.orderMainMapper = orderMainMapper;
    }

    @Override
    //@Cacheable
    public Map<String,Object> queryAll(OrderMainQueryCriteria criteria, Pageable pageable){
        Page<OrderMain> page = orderMainRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(orderMainMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<OrderMainDto> queryAll(OrderMainQueryCriteria criteria){
        return orderMainMapper.toDto(orderMainRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public OrderMainDto findById(Long id) {
        OrderMain orderMain = orderMainRepository.findById(id).orElseGet(OrderMain::new);
        ValidationUtil.isNull(orderMain.getId(),"OrderMain","id",id);
        return orderMainMapper.toDto(orderMain);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public OrderMainDto create(OrderMain resources) {
        return orderMainMapper.toDto(orderMainRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(OrderMain resources) {
        OrderMain orderMain = orderMainRepository.findById(resources.getId()).orElseGet(OrderMain::new);
        ValidationUtil.isNull( orderMain.getId(),"OrderMain","id",resources.getId());
        orderMain.copy(resources);
        orderMainRepository.save(orderMain);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            orderMainRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<OrderMainDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (OrderMainDto orderMain : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("订单编号", orderMain.getOrderSn());
            map.put("提交时间", orderMain.getCreateTime());
            map.put("用户帐号", orderMain.getMemberUsername());
            map.put("订单总金额", orderMain.getTotalAmount());
            map.put("应付金额", orderMain.getPayAmount());
            map.put("运费金额", orderMain.getFreightAmount());
            map.put("支付方式", orderMain.getPayType());
            map.put("订单状态", orderMain.getStatus());
            map.put("物流公司", orderMain.getDeliveryCompany());
            map.put("物流单号", orderMain.getDeliverySn());
            map.put("收货人姓名", orderMain.getReceiverName());
            map.put("收货人电话", orderMain.getReceiverPhone());
            map.put("收货人邮编", orderMain.getReceiverPostCode());
            map.put("省份/直辖市", orderMain.getReceiverProvince());
            map.put("城市", orderMain.getReceiverCity());
            map.put("区", orderMain.getReceiverRegion());
            map.put("详细地址", orderMain.getReceiverDetailAddress());
            map.put("订单备注", orderMain.getNote());
            map.put("确认收货状态", orderMain.getConfirmStatus());
            map.put("删除状态", orderMain.getDeleteStatus());
            map.put("支付时间", orderMain.getPaymentTime());
            map.put("发货时间", orderMain.getDeliveryTime());
            map.put("确认收货时间", orderMain.getReceiveTime());
            map.put("修改时间", orderMain.getModifyTime());
            map.put("所属商家", orderMain.getDept().getName());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}