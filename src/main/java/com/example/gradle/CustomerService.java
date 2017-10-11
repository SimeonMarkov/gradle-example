package com.example.gradle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class CustomerService {

    @Value("${nuts.value}")
    private String value;

    public void assignValueTo(Customer customer) {
        customer.setFirstName(value);
    }

    public Address updateAddressStreet(String address1) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Address address = null;
        try {
            address = objectMapper.readValue(address1, Address.class);
            address.setStreet(null);
            System.out.println(address.getStreet().length());
            System.out.println("Exception was handled");
            System.out.println("Exception was handled again");
        } catch (NullPointerException e) {
            log.info("Street was null");
        } catch (UnrecognizedPropertyException e) {
            log.info("Unrecognized property");
            throw e;
        }
        System.out.println("Outside try/catch");
        return address;
    }
}
