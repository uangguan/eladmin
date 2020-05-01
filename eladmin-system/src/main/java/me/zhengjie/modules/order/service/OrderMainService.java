package me.zhengjie.modules.order.service;

import me.zhengjie.modules.order.repository.OrderMainPo;
import me.zhengjie.modules.order.service.dto.OrderMainDto;
import me.zhengjie.modules.order.service.dto.OrderMainQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @author hgw
*/
public interface OrderMainService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(OrderMainQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<OrderMainDto>
    */
    List<OrderMainDto> queryAll(OrderMainQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return OrderMainDto
     */
    OrderMainDto findById(Long id);

    /**
    * 创建
    * @param resources /
    * @return OrderMainDto
    */
    OrderMainDto create(OrderMainPo resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(OrderMainPo resources);

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
    void download(List<OrderMainDto> all, HttpServletResponse response) throws IOException;
}