package com.teamgold.goldenharvestsales.sales.command.application.service;

public interface SalesOrderCommandService {
    void cancelOrder(String salesOrderId);

    void approveOrder(String salesOrderId);
}
