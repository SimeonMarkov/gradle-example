package com.example.gradle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

// model for addresses

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @NotNull
    private String street;
    @NotNull
    private String zipCode;
    @NotNull
    private String country;
    @NotNull
    private String number;

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.toJson(this);
    }
}
