package com.example.gradle.controller;

import com.example.gradle.Customer;
import com.example.gradle.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    private CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @RequestMapping("/assign")
    public Customer assignCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return customer;
    }
}
