package com.teamgold.goldenharvestsales.sales.command.application.event;

import com.teamgold.goldenharvestsales.sales.command.application.event.dto.SalesOrderResultEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SalesOrderResultConsumer {

    private final ApplicationEventPublisher publisher;

    @KafkaListener(topics = "sales.order.result", groupId = "golden.harvest.sales.processor")
    public void handle(SalesOrderResultEvent event) {
        log.info("sales.order.result event consuming");

        publisher.publishEvent(event);
    }
}
