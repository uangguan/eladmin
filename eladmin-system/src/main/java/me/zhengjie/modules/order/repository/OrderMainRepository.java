package me.zhengjie.modules.order.repository;

import me.zhengjie.modules.order.domain.OrderMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author hgw
*/
public interface OrderMainRepository extends JpaRepository<OrderMain, Long>, JpaSpecificationExecutor<OrderMain> {
}