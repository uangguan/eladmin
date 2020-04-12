package me.zhengjie.modules.product.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.product.domain.ProductCatagory;
import me.zhengjie.modules.product.service.ProductCatagoryService;
import me.zhengjie.modules.product.service.dto.ProductCatagoryQueryCriteria;
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
* @date 2020-04-12
*/
@Api(tags = "商品分类管理")
@RestController
@RequestMapping("/api/productCatagory")
public class ProductCatagoryController {

    private final ProductCatagoryService productCatagoryService;

    public ProductCatagoryController(ProductCatagoryService productCatagoryService) {
        this.productCatagoryService = productCatagoryService;
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
}