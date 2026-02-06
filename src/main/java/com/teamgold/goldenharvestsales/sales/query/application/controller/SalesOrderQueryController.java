package com.teamgold.goldenharvestsales.sales.query.application.controller;


import com.teamgold.goldenharvestsales.common.response.ApiResponse;
import com.teamgold.goldenharvestsales.sales.query.application.dto.*;
import com.teamgold.goldenharvestsales.sales.query.application.service.SalesOrderQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SalesOrderQueryController {
    private final SalesOrderQueryService salesOrderQueryService;

    @GetMapping("/my-orders")
    public ResponseEntity<ApiResponse<Page<OrderHistoryResponse>>> getMyOrderHistory(
            @AuthenticationPrincipal Jwt jwt,
            @ModelAttribute MyOrderSearchCondition searchCondition, Pageable pageable) {
                Page<OrderHistoryResponse> orderHistory = salesOrderQueryService.getMyOrderHistory(jwt.getSubject(), searchCondition, pageable);
        return ResponseEntity.ok(ApiResponse.success(orderHistory));
    }

    @GetMapping("/{salesOrderId}")
    public ResponseEntity<ApiResponse<OrderHistoryResponse>> getOrderDetail(@PathVariable String salesOrderId) {
        OrderHistoryResponse orderDetail = salesOrderQueryService.getOrderDetail(salesOrderId);
        return ResponseEntity.ok(ApiResponse.success(orderDetail));
    }

    // 관리자가 사용자 주문 내역 조회하는 기능
    @GetMapping("/all-orders")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Page<AdminOrderHistoryResponse>>> getAllOrderHistory(@ModelAttribute AdminOrderSearchCondition searchCondition, Pageable pageable) {
        Page<AdminOrderHistoryResponse> orderHistory = salesOrderQueryService.getAllOrderHistory(searchCondition, pageable);
        return ResponseEntity.ok(ApiResponse.success(orderHistory));
    }

    // 관리자용 상세 주문 내역 조회 기능
    @GetMapping("/orders/{salesOrderId}/details")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<AdminOrderDetailResponse>> getAdminOrderDetail(@PathVariable String salesOrderId) {
        AdminOrderDetailResponse orderDetail = salesOrderQueryService.getAdminOrderDetail(salesOrderId);
        return ResponseEntity.ok(ApiResponse.success(orderDetail));
    }

    @GetMapping("/best-order")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> getBestOrderItem() {
        return ResponseEntity.ok(ApiResponse.success(salesOrderQueryService.getBestOrderItem()));
    }
}
