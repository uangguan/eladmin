package me.zhengjie.modules.product.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.config.DataScope;
import me.zhengjie.modules.product.domain.ProductCatagory;
import me.zhengjie.modules.product.service.ProductCatagoryService;
import me.zhengjie.modules.product.service.dto.ProductCatagoryDto;
import me.zhengjie.modules.product.service.dto.ProductCatagoryQueryCriteria;
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
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;

/**
* @author hgw
* @date 2020-04-12
*/
@Api(tags = "商品分类管理")
@RestController
@RequestMapping("/api/productCatagory")
public class ProductCatagoryController {

    private final ProductCatagoryService productCatagoryService;

    private final DataScope dataScope;
    private final DeptService deptService;

    public ProductCatagoryController(ProductCatagoryService productCatagoryService, DataScope dataScope, DeptService deptService) {
        this.productCatagoryService = productCatagoryService;
        this.dataScope = dataScope;
        this.deptService = deptService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('productCatagory:list')")
    public void download(HttpServletResponse response, ProductCatagoryQueryCriteria criteria) throws IOException {
        productCatagoryService.download(productCatagoryService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询商品分类")
    @ApiOperation("查询商品分类")
    @PreAuthorize("@el.check('productCatagory:list')")
    public ResponseEntity<Object> getProductCatagorys(ProductCatagoryQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(productCatagoryService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增商品分类")
    @ApiOperation("新增商品分类")
    @PreAuthorize("@el.check('productCatagory:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody ProductCatagory resources){
        return new ResponseEntity<>(productCatagoryService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改商品分类")
    @ApiOperation("修改商品分类")
    @PreAuthorize("@el.check('productCatagory:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody ProductCatagory resources){
        productCatagoryService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除商品分类")
    @ApiOperation("删除商品分类")
    @PreAuthorize("@el.check('productCatagory:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        productCatagoryService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/tree")
    @Log("查询商品分类树")
    @ApiOperation("查询商品分类树")
    @PreAuthorize("@el.check('productCatagory:list')")
    public ResponseEntity<Object> getProductCatagorys(ProductCatagoryQueryCriteria criteria){
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
                List<ProductCatagoryDto> productCatagoryDtos = productCatagoryService.queryAll(criteria);
                return new ResponseEntity<>(productCatagoryService.buildTree(productCatagoryDtos),HttpStatus.OK);
            }
            // 否则取并集
        } else {
            result.addAll(deptSet);
            result.addAll(deptIds);
            criteria.setDeptIds(result);
            List<ProductCatagoryDto> productCatagoryDtos = productCatagoryService.queryAll(criteria);
            return new ResponseEntity<>(productCatagoryService.buildTree(productCatagoryDtos),HttpStatus.OK);
        }
    }
}