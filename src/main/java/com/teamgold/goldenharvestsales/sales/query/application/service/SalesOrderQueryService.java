package com.teamgold.goldenharvestsales.sales.query.application.service;

import com.teamgold.goldenharvestsales.sales.query.application.dto.*;
import com.teamgold.goldenharvestsales.sales.query.application.dto.response.BestOrderItemResponse;
import com.teamgold.goldenharvestsales.sales.query.application.dto.response.UserFrequentOrderResponse;
import com.teamgold.goldenharvestsales.sales.query.application.dto.response.UserOrderInfoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SalesOrderQueryService {

    Page<OrderHistoryItemDetailResponse> getMyOrderHistory(String userEmail, MyOrderSearchCondition searchCondition,
                                                           Pageable pageable);

    OrderHistoryResponse getOrderDetail(String salesOrderId);

    Page<AdminOrderHistoryResponse> getAllOrderHistory(AdminOrderSearchCondition searchCondition, Pageable pageable);

    AdminOrderDetailResponse getAdminOrderDetail(String salesOrderId);

    BestOrderItemResponse getBestOrderItem();

    UserOrderInfoResponse getUserOrderInfo(String userEmail);

    List<UserFrequentOrderResponse> getUserFrequentOrders(String userEmail);
}
