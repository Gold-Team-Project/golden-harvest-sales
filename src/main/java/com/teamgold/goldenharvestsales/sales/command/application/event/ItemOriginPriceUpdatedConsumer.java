package com.teamgold.goldenharvestsales.sales.command.application.event;

import com.teamgold.goldenharvestsales.sales.command.application.event.dto.ItemOriginPriceUpdatedEvent;
import com.teamgold.goldenharvestsales.sales.command.application.event.dto.UserStatusUpdatedEvent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ItemOriginPriceUpdatedConsumer {

    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    @KafkaListener(topics = "item.origin.price.updated", groupId = "golden.harvest.sales.processor")
    public void consume(ItemOriginPriceUpdatedEvent event) {
        log.info("item.origin.price.updated event consuming");

        eventPublisher.publishEvent(event);
    }
}
