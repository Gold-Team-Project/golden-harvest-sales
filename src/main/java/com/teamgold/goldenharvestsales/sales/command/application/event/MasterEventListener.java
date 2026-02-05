package com.teamgold.goldenharvestsales.sales.command.application.event;

import com.teamgold.goldenharvestsales.sales.command.application.event.dto.ItemMasterUpdatedEvent;
import com.teamgold.goldenharvestsales.sales.command.domain.SalesSku;
import com.teamgold.goldenharvestsales.sales.command.infrastructure.repository.SalesSkuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MasterEventListener {

    private final SalesSkuRepository salesSkuRepository;

    @Async
    @EventListener
    public void handleSkuInfoChange(ItemMasterUpdatedEvent itemMasterUpdatedEvent) {
        log.info("SKU 정보 변경 이벤트 수신 : {}", itemMasterUpdatedEvent.skuNo());
        SalesSku salesSku = SalesSku.builder()
                .skuNo(itemMasterUpdatedEvent.skuNo())
                .itemName(itemMasterUpdatedEvent.itemName())
                .gradeName(itemMasterUpdatedEvent.gradeName())
                .varietyName(itemMasterUpdatedEvent.varietyName())
                .baseUnit(itemMasterUpdatedEvent.baseUnit())
                .currentOriginPrice(itemMasterUpdatedEvent.currentOriginPrice().doubleValue())
                .fileUrl(itemMasterUpdatedEvent.fileUrl())
                .build();

        // Sales 서비스의 DB에 저장
        salesSkuRepository.save(salesSku);
    }
}
