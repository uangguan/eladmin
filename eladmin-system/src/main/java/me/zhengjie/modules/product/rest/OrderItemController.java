package me.zhengjie.modules.product.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.product.domain.OrderItem;
import me.zhengjie.modules.product.service.OrderItemService;
import me.zhengjie.modules.product.service.dto.OrderItemQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @author hgw
*/
@Api(tags = "订单明细管理")
@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('orderItem:list')")
    public void download(HttpServletResponse response, OrderItemQueryCriteria criteria) throws IOException {
        orderItemService.download(orderItemService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询订单明细")
    @ApiOperation("查询订单明细")
    @PreAuthorize("@el.check('orderItem:list')")
    public ResponseEntity<Object> getOrderItems(OrderItemQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(orderItemService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增订单明细")
    @ApiOperation("新增订单明细")
    @PreAuthorize("@el.check('orderItem:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody OrderItem resources){
        return new ResponseEntity<>(orderItemService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改订单明细")
    @ApiOperation("修改订单明细")
    @PreAuthorize("@el.check('orderItem:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody OrderItem resources){
        orderItemService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除订单明细")
    @ApiOperation("删除订单明细")
    @PreAuthorize("@el.check('orderItem:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        orderItemService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}