package com.example.gradle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonIgnore
    private Integer id;
    @Column
    @NotBlank
    @NonNull
    private String customerName;
    @Column
    @NonNull
    @NotBlank
    private String contactName;
    @Column
    @NotBlank
    @NonNull
    private String address;
    @Column
    @NotBlank
    @NonNull
    private String city;
    @Column
    @NotBlank
    @NonNull
    private String postalCode;
    @Column
    @NotBlank
    @NonNull
    private String country;
}
