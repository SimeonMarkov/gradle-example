package com.example.gradle.converter;

import com.example.gradle.Address;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Converter
public class EmbeddedTypeConverter implements AttributeConverter<Address, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Address attribute) {

        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Address convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, Address.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
