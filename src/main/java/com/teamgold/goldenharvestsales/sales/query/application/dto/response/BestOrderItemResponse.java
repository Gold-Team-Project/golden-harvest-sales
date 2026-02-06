package com.teamgold.goldenharvestsales.sales.query.application.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BestOrderItemResponse {
    private String itemName;
    private Integer orderCount;
    private Long quantity;
}
