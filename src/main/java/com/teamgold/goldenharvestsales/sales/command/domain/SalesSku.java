package com.teamgold.goldenharvestsales.sales.command.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_sales_sku")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SalesSku {
    @Id
    @Column(name = "sku_no", length = 20)
    private String skuNo; //sku 번호

    @Column(name = "item_name", length = 20)
    private String itemName; // 품목명

    @Column(name = "grade_name", length = 20)
    private String gradeName; // 등급명

    @Column(name = "variety_name", length = 20)
    private String varietyName; // 품종명

    @Column(name = "base_unit")
    private String baseUnit;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "current_origin_price")
    private Double currentOriginPrice;

    public Double updateOriginPrice(Double currentOriginPrice) {
        this.currentOriginPrice = currentOriginPrice;
        return this.currentOriginPrice;
    }
}
