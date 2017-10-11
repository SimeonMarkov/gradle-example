package com.example.gradle;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class InvoiceAddress extends Address {

    private String addressAdditionalInfo;

    public InvoiceAddress() {

    }


    public InvoiceAddress(Address address, String addressAdditionalInfo) {
        super(address.getStreet(), address.getZipCode(), address.getCountry(), address.getNumber());
        this.addressAdditionalInfo = addressAdditionalInfo;
    }
}
