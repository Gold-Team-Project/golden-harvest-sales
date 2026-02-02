package com.teamgold.goldenharvestsales.sales.query.application.service;


import com.teamgold.goldenharvestsales.sales.query.application.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SalesOrderQueryService {

    Page<OrderHistoryResponse> getMyOrderHistory(String userEmail, MyOrderSearchCondition searchCondition, Pageable pageable);

    OrderHistoryResponse getOrderDetail(String salesOrderId);

    Page<AdminOrderHistoryResponse> getAllOrderHistory(AdminOrderSearchCondition searchCondition, Pageable pageable);

    AdminOrderDetailResponse getAdminOrderDetail(String salesOrderId);
}
