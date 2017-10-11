package com.example.gradle.controller;

import com.example.gradle.Address;
import com.example.gradle.Customer;
import com.example.gradle.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @RequestMapping("/assign")
    public Customer assignCustomer(@RequestBody Customer customer) {
        customerService.assignValueTo(customer);
        return customer;
    }

    @PostMapping
    @RequestMapping
    public ResponseEntity<Address> updateStreet(@RequestBody String address) {
        Address tempAddress = null;
        try {
            tempAddress = customerService.updateAddressStreet(address);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tempAddress);
    }

}
