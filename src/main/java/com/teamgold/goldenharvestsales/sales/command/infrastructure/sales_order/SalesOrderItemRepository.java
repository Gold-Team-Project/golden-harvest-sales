package com.teamgold.goldenharvestsales.sales.command.infrastructure.sales_order;

import com.teamgold.goldenharvestsales.sales.command.domain.sales_order.SalesOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesOrderItemRepository extends JpaRepository<SalesOrderItem, String> {

    Optional<SalesOrderItem> findBySalesOrderItemId(String salesOrderItemId);
}
