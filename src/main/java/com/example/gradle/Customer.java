package com.example.gradle;

import com.example.gradle.converter.EmbeddedTypeConverter;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
public class Customer {

    @Id
    private String id;
    @Column
    @NonNull
    private String firstName;
    @Column
    @NonNull
    private String lastName;
    @Column
    @Convert(converter = EmbeddedTypeConverter.class)
    @NonNull
    private Address address;
}
