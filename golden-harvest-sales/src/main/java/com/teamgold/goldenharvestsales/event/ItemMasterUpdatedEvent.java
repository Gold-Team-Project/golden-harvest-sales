package com.teamgold.goldenharvestsales.event;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ItemMasterUpdatedEvent(
	String skuNo,
	String itemName,
	String gradeName,
	String varietyName,
	String fileUrl,
	String baseUnit,
	Boolean isActive,
	BigDecimal currentOriginPrice
) { }
