package com.teamgold.goldenharvestsales.sales.query.application.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserFrequentOrderResponse {
    String itemName;
    String varietyName;
    String fileUrl;
    Integer orderCount;
}
