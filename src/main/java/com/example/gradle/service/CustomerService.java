package com.example.gradle.service;

import com.example.gradle.Customer;
import com.example.gradle.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        customerRepository.save(customer);
    }
}
