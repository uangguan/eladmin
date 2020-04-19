package me.zhengjie.modules.product.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.config.DataScope;
import me.zhengjie.modules.product.domain.Product;
import me.zhengjie.modules.product.service.ProductService;
import me.zhengjie.modules.product.service.dto.ProductQueryCriteria;
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
@Api(tags = "商品管理管理")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    private final DataScope dataScope;
    private final DeptService deptService;

    public ProductController(ProductService productService, DataScope dataScope, DeptService deptService) {
        this.productService = productService;
        this.dataScope = dataScope;
        this.deptService = deptService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('product:list')")
    public void download(HttpServletResponse response, ProductQueryCriteria criteria) throws IOException {
        productService.download(productService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询商品管理")
    @ApiOperation("查询商品管理")
    @PreAuthorize("@el.check('product:list')")
    public ResponseEntity<Object> getProducts(ProductQueryCriteria criteria, Pageable pageable){

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
                return new ResponseEntity<>(productService.queryAll(criteria,pageable),HttpStatus.OK);
            }
            // 否则取并集
        } else {
            result.addAll(deptSet);
            result.addAll(deptIds);
            criteria.setDeptIds(result);
            return new ResponseEntity<>(productService.queryAll(criteria,pageable),HttpStatus.OK);
        }
    }

    @PostMapping
    @Log("新增商品管理")
    @ApiOperation("新增商品管理")
    @PreAuthorize("@el.check('product:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Product resources){
        return new ResponseEntity<>(productService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改商品管理")
    @ApiOperation("修改商品管理")
    @PreAuthorize("@el.check('product:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody Product resources){
        productService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除商品管理")
    @ApiOperation("删除商品管理")
    @PreAuthorize("@el.check('product:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        productService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}