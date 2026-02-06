package com.teamgold.goldenharvestsales.sales.query.application.mapper;

import com.teamgold.goldenharvestsales.sales.query.application.dto.response.BestOrderItemResponse;
import com.teamgold.goldenharvestsales.sales.query.application.dto.response.UserFrequentOrderResponse;
import com.teamgold.goldenharvestsales.sales.query.application.dto.response.UserOrderInfoResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("""
    SELECT
        COUNT(CASE WHEN so.created_at >= CURDATE() THEN 1 END) AS todayOrders,
        COUNT(CASE WHEN so.created_at >= DATE_SUB(CURDATE(), INTERVAL WEEKDAY(CURDATE()) DAY) THEN 1 END) AS weeklyOrders,
        COUNT(CASE WHEN so.created_at >= DATE_SUB(CURDATE(), INTERVAL DAYOFMONTH(CURDATE()) - 1 DAY) THEN 1 END) AS monthlyOrders,
        COUNT(CASE WHEN so.created_at IS NOT NULL THEN 1 END) AS averageOrders,
        COUNT(CASE WHEN so.created_at IS NOT NULL THEN 1 END) AS totalOrders,
        COUNT(CASE WHEN so.order_status_id = 1 THEN 1 END) AS orderReceived,
        COUNT(CASE WHEN so.order_status_id = 2 THEN 1 END) AS productPreparing,
        COUNT(CASE WHEN so.order_status_id = 3 THEN 1 END) AS shipping,
        COUNT(CASE WHEN so.order_status_id = 4 THEN 1 END) AS delivered,
        COUNT(CASE WHEN so.order_status_id = 5 THEN 1 END) AS cancelled
    FROM tb_sales_order so
    WHERE so.user_email = #{userEmail}
    """)
    UserOrderInfoResponse findUserOrderInfo(@Param("userEmail") String userEmail);

    @Select("""
    SELECT
        ss.item_name AS itemName,
        ss.variety_name AS varietyName,
        ss.file_url AS fileUrl,
        COUNT(*) AS orderCount
    FROM tb_sales_order_item soi
    JOIN tb_sales_sku ss
    ON soi.sku_no = ss.sku_no
    WHERE ss.user_email = #{userEmail}
    GROUP BY ss.item_name, ss.variety_name, ss.file_url
    ORDER BY orderCount DESC
    LIMIT 5
    """)
    List<UserFrequentOrderResponse> findAllUserFrequentOrders(@Param("userEmail") String userEmail);
}
