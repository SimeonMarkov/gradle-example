package com.example.gradle;

import com.example.gradle.converter.EmbeddedTypeConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Customer {

    @Id
    private String id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    @Convert(converter = EmbeddedTypeConverter.class)
    private Address address;
}
