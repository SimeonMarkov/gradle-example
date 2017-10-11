package com.example.gradle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String firstName;
    private String lastName;
    private Address deliveryAddress;
    private InvoiceAddress invoiceAddress;

    public Customer convert(String value, Consumer<String> supplier) {
        if (value != null) {
            supplier.accept(value);
        } else {
            supplier.accept("default street");
        }
        System.out.println("Now invoice address is:" + invoiceAddress);
        return this;
    }
}
