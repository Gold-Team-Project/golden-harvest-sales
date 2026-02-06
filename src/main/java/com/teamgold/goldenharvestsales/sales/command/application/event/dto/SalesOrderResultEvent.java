package com.teamgold.goldenharvestsales.sales.command.application.event.dto;

import lombok.Builder;

@Builder
public record SalesOrderResultEvent(
        String salesOrderItemId,
        String status
) { }