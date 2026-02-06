package com.teamgold.goldenharvestsales.sales.query.application.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserOrderInfoResponse {

    Integer todayOrders;
    Integer weeklyOrders;
    Integer MonthlyOrders;
    Integer averageOrders;
    Integer totalOrders;

    Integer orderReceived;
    Integer productPreparing;
    Integer shipping;
    Integer delivered;
    Integer cancelled;
}
