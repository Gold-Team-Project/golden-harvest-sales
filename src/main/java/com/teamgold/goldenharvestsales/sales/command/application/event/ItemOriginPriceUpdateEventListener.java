package com.teamgold.goldenharvestsales.sales.command.application.event;

import com.teamgold.goldenharvestsales.common.exception.BusinessException;
import com.teamgold.goldenharvestsales.common.exception.ErrorCode;
import com.teamgold.goldenharvestsales.sales.command.application.event.dto.ItemOriginPriceUpdatedEvent;
import com.teamgold.goldenharvestsales.sales.command.domain.SalesSku;
import com.teamgold.goldenharvestsales.sales.command.infrastructure.repository.SalesSkuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ItemOriginPriceUpdateEventListener {

    private final SalesSkuRepository salesSkuRepository;

    @Async
    @EventListener
    @Transactional
    public void handlePriceChange(ItemOriginPriceUpdatedEvent event) {
        log.info("원가 정보 변경 이벤트 수신: {}", event.skuNo());

        SalesSku salesSku = salesSkuRepository.findBySkuNo(event.skuNo()).orElseThrow(
                () -> new BusinessException(ErrorCode.MASTER_DATA_NOT_FOUND)
        );

        if (event.originPrice() == null) {
            throw new BusinessException(ErrorCode.INVALID_REQUEST);
        }

        salesSku.updateOriginPrice(event.originPrice().doubleValue());
        salesSkuRepository.save(salesSku);
    }
}
