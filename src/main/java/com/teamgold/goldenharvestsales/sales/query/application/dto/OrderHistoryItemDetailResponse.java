package com.teamgold.goldenharvestsales.sales.query.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderHistoryItemDetailResponse {
    private String salesOrderItemId;
    private String salesOrderId;
    private String orderStatus;
    private String orderStatusType;
    private LocalDateTime createdAt;
    private String itemName;
    private String gradeName;
    private String varietyName;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String fileUrl;
}
