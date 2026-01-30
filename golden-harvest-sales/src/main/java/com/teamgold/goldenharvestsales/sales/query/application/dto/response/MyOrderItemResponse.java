package com.teamgold.goldenharvestsales.sales.query.application.dto.response;

import com.teamgold.goldenharvestsales.sales.command.domain.sales_order.SalesOrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyOrderItemResponse {
    private String salesOrderItemId;
    private String skuNo;
    private Integer quantity;

    public static MyOrderItemResponse from(SalesOrderItem salesOrderItem) {
        return MyOrderItemResponse.builder()
                .salesOrderItemId(salesOrderItem.getSalesOrderItemId())
                .skuNo(salesOrderItem.getSkuNo())
                .quantity(salesOrderItem.getQuantity())
                .build();
    }
}
