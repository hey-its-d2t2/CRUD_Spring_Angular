package com.CRUD_Spring_Angular.service;

import com.CRUD_Spring_Angular.entity.Customer;
import com.CRUD_Spring_Angular.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer postCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
