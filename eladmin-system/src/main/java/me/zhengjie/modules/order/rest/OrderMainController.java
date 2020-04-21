package me.zhengjie.modules.order.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.config.DataScope;
import me.zhengjie.modules.order.domain.OrderMain;
import me.zhengjie.modules.order.service.OrderMainService;
import me.zhengjie.modules.order.service.dto.OrderMainQueryCriteria;
import me.zhengjie.modules.system.service.DeptService;
import me.zhengjie.utils.PageUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;

/**
* @author hgw
*/
@Api(tags = "订单管理管理")
@RestController
@RequestMapping("/api/orderMain")
public class OrderMainController {

    private final OrderMainService orderMainService;
    private final DeptService deptService;
    private final DataScope dataScope;


    public OrderMainController(OrderMainService orderMainService, DeptService deptService, DataScope dataScope) {
        this.orderMainService = orderMainService;
        this.deptService = deptService;
        this.dataScope = dataScope;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('orderMain:list')")
    public void download(HttpServletResponse response, OrderMainQueryCriteria criteria) throws IOException {
        orderMainService.download(orderMainService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询订单管理")
    @ApiOperation("查询订单管理")
    @PreAuthorize("@el.check('orderMain:list')")
    public ResponseEntity<Object> getOrderMains(OrderMainQueryCriteria criteria, Pageable pageable){
        Set<Long> deptSet = new HashSet<>();
        Set<Long> result = new HashSet<>();
        if (!ObjectUtils.isEmpty(criteria.getDeptId())) {
            deptSet.add(criteria.getDeptId());
            deptSet.addAll(dataScope.getDeptChildren(deptService.findByPid(criteria.getDeptId())));
        }
        // 数据权限
        Set<Long> deptIds = dataScope.getDeptIds();
        // 查询条件不为空并且数据权限不为空则取交集
        if (!CollectionUtils.isEmpty(deptIds) && !CollectionUtils.isEmpty(deptSet)){
            // 取交集
            result.addAll(deptSet);
            result.retainAll(deptIds);
            // 若无交集，则代表无数据权限
            criteria.setDeptIds(result);
            if(result.size() == 0){
                return new ResponseEntity<>(PageUtil.toPage(null,0),HttpStatus.OK);
            } else {
                return new ResponseEntity<>(orderMainService.queryAll(criteria,pageable),HttpStatus.OK);
            }
            // 否则取并集
        } else {
            result.addAll(deptSet);
            result.addAll(deptIds);
            criteria.setDeptIds(result);
            return new ResponseEntity<>(orderMainService.queryAll(criteria,pageable),HttpStatus.OK);
        }
    }

    @PostMapping
    @Log("新增订单管理")
    @ApiOperation("新增订单管理")
    @PreAuthorize("@el.check('orderMain:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody OrderMain resources){
        return new ResponseEntity<>(orderMainService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改订单管理")
    @ApiOperation("修改订单管理")
    @PreAuthorize("@el.check('orderMain:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody OrderMain resources){
        orderMainService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除订单管理")
    @ApiOperation("删除订单管理")
    @PreAuthorize("@el.check('orderMain:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        orderMainService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}