package com.teamgold.goldenharvestsales.sales.query.application.service;


import com.teamgold.goldenharvestsales.common.exception.BusinessException;
import com.teamgold.goldenharvestsales.common.exception.ErrorCode;
import com.teamgold.goldenharvestsales.sales.query.application.dto.*;
import com.teamgold.goldenharvestsales.sales.query.application.mapper.SalesOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SalesOrderQueryServiceImpl implements SalesOrderQueryService {

    private final SalesOrderMapper salesOrderMapper;

    @Override
    public Page<OrderHistoryResponse> getMyOrderHistory(String userEmail, MyOrderSearchCondition searchCondition, Pageable pageable) {
        long totalCount = salesOrderMapper.countOrderHistoryByUserEmail(userEmail, searchCondition);
        List<OrderHistoryResponse> orderHistory = salesOrderMapper.findOrderHistoryByUserEmail(userEmail, searchCondition, pageable);
        return new PageImpl<>(orderHistory, pageable, totalCount);
    }

    @Override
    public OrderHistoryResponse getOrderDetail(String salesOrderId) {
        OrderHistoryResponse orderDetail = salesOrderMapper.findOrderDetailBySalesOrderId(salesOrderId);
        if (orderDetail == null) {
            throw new BusinessException(ErrorCode.ORDER_NOT_FOUND);
        }
        return orderDetail;
    }

    @Override
    public Page<AdminOrderHistoryResponse> getAllOrderHistory(AdminOrderSearchCondition searchCondition, Pageable pageable) {
        long totalCount = salesOrderMapper.countAllOrderHistory(searchCondition);
        List<AdminOrderHistoryResponse> orderHistory = salesOrderMapper.findAllOrderHistory(searchCondition, pageable);
        return new PageImpl<>(orderHistory, pageable, totalCount);
    }

    @Override
    public AdminOrderDetailResponse getAdminOrderDetail(String salesOrderId) {
        AdminOrderDetailResponse orderDetail = salesOrderMapper.findAdminOrderDetailBySalesOrderId(salesOrderId);
        if (orderDetail == null) {
            throw new BusinessException(ErrorCode.ORDER_NOT_FOUND);
        }
        return orderDetail;
    }
}