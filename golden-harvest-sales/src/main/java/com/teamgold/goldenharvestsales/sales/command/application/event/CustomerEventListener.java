package com.teamgold.goldenharvestsales.sales.command.application.event;

import com.teamgold.goldenharvestsales.event.UserUpdatedEvent;
import com.teamgold.goldenharvestsales.sales.command.domain.customer.Customer;
import com.teamgold.goldenharvestsales.sales.command.infrastructure.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CustomerEventListener {

    private final CustomerRepository customerRepository;

    @EventListener
    @Transactional
    public void handleUserUpdatedEvent(UserUpdatedEvent event) {
        Customer customer = Customer.builder()
                .email(event.email())
                .company(event.company())
                .businessNumber(event.businessNumber())
                .name(event.name())
                .phoneNumber(event.phoneNumber())
                .addressLine1(event.addressLine1())
                .addressLine2(event.addressLine2())
                .postalCode(event.postalCode())
                .build();
        
        customerRepository.save(customer);
    }
}