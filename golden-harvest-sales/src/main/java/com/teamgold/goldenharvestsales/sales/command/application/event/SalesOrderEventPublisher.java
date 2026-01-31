package com.teamgold.goldenharvestsales.sales.command.application.event;

import com.teamgold.goldenharvestsales.sales.command.application.event.dto.SalesOrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalesOrderEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public void publishSalesOrderEvent(SalesOrderCreatedEvent salesOrderEvent) {
        eventPublisher.publishEvent(salesOrderEvent);
    }
}
