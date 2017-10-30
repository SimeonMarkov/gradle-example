package com.example.gradle;

import com.example.gradle.model.City;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private String name;
    private City city;
}
