package com.teamgold.goldenharvestsales.sales.command.infrastructure.repository;

import com.teamgold.goldenharvestsales.sales.command.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}