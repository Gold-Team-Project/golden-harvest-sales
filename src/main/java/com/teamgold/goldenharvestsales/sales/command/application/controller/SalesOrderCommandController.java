package com.teamgold.goldenharvestsales.sales.command.application.controller;

import com.teamgold.goldenharvestsales.common.response.ApiResponse;
import com.teamgold.goldenharvestsales.sales.command.application.service.SalesOrderCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SalesOrderCommandController {

    private final SalesOrderCommandService salesOrderCommandService;

    // 관리자가 사용자 주문 취소하는 기능
    @PatchMapping("/orders/{salesOrderId}/cancel")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Void>> cancelOrder(@PathVariable String salesOrderId) {
        salesOrderCommandService.cancelOrder(salesOrderId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    // 관리자가 사용자 주문 승인하는 기능
    @PatchMapping("/orders/{salesOrderId}/approve")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Void>> approveOrder(@PathVariable String salesOrderId) {
        salesOrderCommandService.approveOrder(salesOrderId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
