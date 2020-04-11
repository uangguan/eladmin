package me.zhengjie.modules.product.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.product.domain.Product;
import me.zhengjie.modules.product.service.ProductService;
import me.zhengjie.modules.product.service.dto.ProductQueryCriteria;
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
* @date 2020-04-11
*/
@Api(tags = "商品管理管理")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
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
        return new ResponseEntity<>(productService.queryAll(criteria,pageable),HttpStatus.OK);
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