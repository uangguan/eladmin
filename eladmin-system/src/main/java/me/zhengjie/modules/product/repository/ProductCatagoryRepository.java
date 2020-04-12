package me.zhengjie.modules.product.repository;

import me.zhengjie.modules.product.domain.ProductCatagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author hgw
* @date 2020-04-12
*/
public interface ProductCatagoryRepository extends JpaRepository<ProductCatagory, Long>, JpaSpecificationExecutor<ProductCatagory> {
}