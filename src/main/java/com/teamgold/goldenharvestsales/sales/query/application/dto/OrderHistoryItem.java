package com.teamgold.goldenharvestsales.sales.query.application.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistoryItem {
    private String itemName; // 품목명
    private String gradeName; // 등급명
    private String varietyName; // 상품명
    private Integer quantity; // 수량
    private BigDecimal price; // 가격
    private String fileUrl; // 이미지 URL
}
