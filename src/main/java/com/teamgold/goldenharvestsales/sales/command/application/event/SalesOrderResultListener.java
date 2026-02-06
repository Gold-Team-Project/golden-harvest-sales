package com.teamgold.goldenharvestsales.sales.command.application.event;

import com.teamgold.goldenharvestsales.common.exception.BusinessException;
import com.teamgold.goldenharvestsales.common.exception.ErrorCode;
import com.teamgold.goldenharvestsales.sales.command.application.event.dto.SalesOrderResultEvent;
import com.teamgold.goldenharvestsales.sales.command.application.service.SalesOrderCommandService;
import com.teamgold.goldenharvestsales.sales.command.domain.sales_order.SalesOrder;
import com.teamgold.goldenharvestsales.sales.command.domain.sales_order.SalesOrderItem;
import com.teamgold.goldenharvestsales.sales.command.infrastructure.sales_order.SalesOrderItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SalesOrderResultListener {

    private final SalesOrderCommandService salesOrderCommandService;
    private final SalesOrderItemRepository salesOrderItemRepository;

    @EventListener
    public void listen(SalesOrderResultEvent event) {
        SalesOrderItem salesOrderItem = salesOrderItemRepository.findBySalesOrderItemId(event.salesOrderItemId()).orElseThrow(
                () -> new BusinessException(ErrorCode.INVALID_REQUEST)
        );

        String salesOrderId = salesOrderItem.getSalesOrder().getSalesOrderId();

        if (event.status().equalsIgnoreCase("success")) {
            salesOrderCommandService.approveOrder(salesOrderId);
        }
        else {
            salesOrderCommandService.cancelOrder(salesOrderId);
        }
    }
}
