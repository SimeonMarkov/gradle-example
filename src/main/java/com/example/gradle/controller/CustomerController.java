package com.example.gradle.controller;

import com.example.gradle.Customer;
import com.example.gradle.service.CustomerService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final ObjectMapper objectMapper;

    @Autowired
    private CustomerController(CustomerService customerService, ObjectMapper objectMapper) {
        this.customerService = customerService;
        this.objectMapper = objectMapper;
        this.objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
    }

    @PostMapping
    @RequestMapping("/assign")
    public Customer assignCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return customer;
    }

    @GetMapping("/")
    public List<Customer> top3() {
        return customerService.selectFirstThreeCustomers();
    }

    @GetMapping("/obj-mapper")
    public JsonNode testObjectMapper() throws IOException {
        String content = "{\"Id\": \"13\", \"FirstName\" : \"rlg mkemtlkr\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.readValue(content, ObjectNode.class);

        ObjectNode node2 = objectMapper.createObjectNode();
        for (Iterator<String> itr = objectNode.fieldNames(); itr.hasNext(); ) {
            String prop = itr.next();
            node2.put(StringUtils.uncapitalize(prop), objectNode.get(prop).textValue());
        }
        return node2;
    }

}
