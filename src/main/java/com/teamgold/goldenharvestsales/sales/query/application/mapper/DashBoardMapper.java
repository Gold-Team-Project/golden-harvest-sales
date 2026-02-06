package com.teamgold.goldenharvestsales.sales.query.application.mapper;

import com.teamgold.goldenharvestsales.sales.query.application.dto.response.BestOrderItemResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DashBoardMapper {

    @Select("""
    SELECT
        ss.item_name AS itemName,
        COUNT(soi.sku_no) AS orderCount,
        SUM(soi.quantity) AS quantity
    FROM tb_sales_order_item soi
    INNER JOIN tb_sales_sku ss ON soi.sku_no = ss.sku_no
    GROUP BY ss.sku_no, ss.item_name
    ORDER BY orderCount DESC, quantity DESC
    LIMIT 1
    """)
    BestOrderItemResponse findBestOrder();
}
