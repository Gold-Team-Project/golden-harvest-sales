package com.teamgold.goldenharvestsales.sales.command.application.event;

import com.teamgold.goldenharvestsales.common.broker.KafkaProducerHelper;
import com.teamgold.goldenharvestsales.sales.command.application.event.dto.SalesOrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SalesOrderEventRelay {

    private final KafkaProducerHelper producer;

    @Async
    @EventListener
    public void salesOrderCreatedRelay(SalesOrderCreatedEvent event) {
        log.info("producing kafka event");
        producer.send("sales.order.created", event.salesOrderItemId(), event, null);
        // Todo: onFailure에 실패 콜백 함수 작성
    }
}
