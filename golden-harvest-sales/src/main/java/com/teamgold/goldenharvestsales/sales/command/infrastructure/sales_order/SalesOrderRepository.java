package com.teamgold.goldenharvestsales.sales.command.infrastructure.sales_order;

import com.teamgold.goldenharvestsales.sales.command.domain.sales_order.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, String> {
}
