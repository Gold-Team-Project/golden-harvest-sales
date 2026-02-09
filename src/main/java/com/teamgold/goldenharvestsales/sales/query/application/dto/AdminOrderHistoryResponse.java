package com.teamgold.goldenharvestsales.sales.query.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminOrderHistoryResponse {
    private String salesOrderId; // 주문번호
    private String orderStatus; // 상태
    private LocalDateTime createdAt; // 생성일
    private BigDecimal totalAmount; // 총 가격
    private String orderStatusType; // 상태 타입 (English)
    private String company; // 회사 이름

    private List<OrderHistoryItem> orderItems;
}
