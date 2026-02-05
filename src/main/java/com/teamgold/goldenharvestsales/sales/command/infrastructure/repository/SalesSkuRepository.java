package com.teamgold.goldenharvestsales.sales.command.infrastructure.repository;

import com.teamgold.goldenharvestsales.sales.command.domain.SalesSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesSkuRepository extends JpaRepository<SalesSku, String> {
    Optional<SalesSku> findBySkuNo(String skuNo);
}
