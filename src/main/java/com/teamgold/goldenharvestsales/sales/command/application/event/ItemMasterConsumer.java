package com.teamgold.goldenharvestsales.sales.command.application.event;

import com.teamgold.goldenharvestsales.sales.command.application.event.dto.ItemMasterUpdatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class ItemMasterConsumer {

    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    @KafkaListener(topics = "item.master.updated", groupId="golden.harvest.sales.processor")
    public void consume(ItemMasterUpdatedEvent event) {
        log.info("item.master.updated event consuming");

        eventPublisher.publishEvent(event);
    }
}
