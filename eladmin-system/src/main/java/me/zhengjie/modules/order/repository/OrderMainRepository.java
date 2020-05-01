package me.zhengjie.modules.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author hgw
*/
public interface OrderMainRepository extends JpaRepository<OrderMainPo, Long>, JpaSpecificationExecutor<OrderMainPo> {
}